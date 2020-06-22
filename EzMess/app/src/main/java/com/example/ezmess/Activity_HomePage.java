package com.example.ezmess;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Activity_HomePage extends AppCompatActivity {
    RecyclerView recyclerView ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        recyclerView=  findViewById(R.id.recylerView);
//
//reference recylerview
//
//setup layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
//
////        set adapter
//
        Message[] messages = loadMessage();
        MessageAdapter adapter = new MessageAdapter(messages);
        recyclerView.setAdapter(adapter);
//        loadMessage();


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
////
//    String url = "http://10.0.2.2/dataMessage/data.php";
//        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Gson gson = new Gson();
//                Message[] messages = gson.fromJson(response,Message[].class);
//                MessageAdapter adapter = new MessageAdapter(messages);
//                recyclerView.setAdapter(adapter);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(Activity_HomePage.this, "Something error", Toast.LENGTH_SHORT).show();
//                Log.d("data","Load error : " + error.getMessage());
//            }
//        });
//        Volley.newRequestQueue(this).add(request);
    }
}
