package com.example.messagerui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> mMsgList;

    static class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout leftLayout,rightLayout;

        TextView leftMsg,rightMsg;

        public ViewHolder(View view){
            super(view);
            leftLayout = view.findViewById(R.id.left_layout);
            rightLayout = view.findViewById(R.id.right_layout);
            leftMsg = view.findViewById(R.id.left_msg);
            rightMsg = view.findViewById(R.id.right_msg);
        }
    }

    public MsgAdapter(List<Msg> msgList){
        mMsgList = msgList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.msg_item,viewGroup,false);

        final ViewHolder holder = new ViewHolder(view);

        holder.leftLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Msg msg = mMsgList.get(position);
                Toast.makeText(v.getContext(),msg.getContent(),Toast.LENGTH_SHORT).show();
            }
        });
        return  holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Msg msg = mMsgList.get(position);

        if(msg.getType() == Msg.TYPE_RECEIVED) {
            //receive message
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        }else if(msg.getType() == Msg.TYPE_SENT) {
            //send message
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(msg.getContent());
        }

    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }
}
