package com.example.messagerui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();

    private EditText inputText;

    private Button btnSend;

    private RecyclerView msgRecyclerView;

    private MsgAdapter adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMsgs();

        inputText = findViewById(R.id.input_text);
        btnSend = findViewById(R.id.btnSend);
        msgRecyclerView = findViewById(R.id.msg_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);

        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1); // refresh when new message
                    msgRecyclerView.scrollToPosition(msgList.size() - 1); // locate to last row
                    inputText.setText(""); // clear inputText
                }
            }
        });


        
    }

    private void initMsgs() {
        Msg msg1 = new Msg("hello", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("hello, what's your name?",Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("my namem is Tom",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg1);
        msgList.add(msg2);

    }
}
