package com.example.ezmess;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Activity_HomePage extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_homepage);


        RecyclerView recyler_chat_view = findViewById(R.id.recyler_chat_view);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyler_chat_view.setLayoutManager(layoutManager);

//        set adapter

        Message[] messages = loadMessage();
        MessageAdapter adapter = new MessageAdapter(messages);
        recyler_chat_view.setAdapter(adapter);


    }
    private Message[] loadMessage(){
//        dummy data
        Message message1= new Message();
        message1.setSender("User 1");
        message1.setText("Hi");

        Message message2= new Message();
        message2.setSender("User 2");
        message2.setText("Game ?");

        Message message3= new Message();
        message3.setSender("User 3");
        message3.setText("coffee ");

        Message message4= new Message();
        message4.setSender("User 4");
        message4.setText("lol");


        return new Message[]{message1,message2,message3,message4};


    }
}
