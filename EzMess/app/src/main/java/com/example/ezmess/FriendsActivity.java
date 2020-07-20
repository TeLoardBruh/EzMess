package com.example.ezmess;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class FriendsActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendsactivity);
//        recyclerView =  findViewById(R.id.recylerfriendactivity);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//
//        loadMessage();
    }

    private void loadMessage(){
//        dummy data
//        Message message1= new Message();
//        message1.setSender("User 1");
//        message1.setText("Hi");
//
//        Message message2= new Message();
//        message2.setSender("User 2");
//        message2.setText("Game ?");
//
//        Message message3= new Message();
//        message3.setSender("User 3");
//        message3.setText("coffee ");
//
//        Message message4= new Message();
//        message4.setSender("User 4");
//        message4.setText("lol");
//
//
//        return new Message[]{message1,message2,message3,message4};
////
        String url = "https://my.api.mockaroo.com/users.json?key=acfdcda0";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Friend[] friends = gson.fromJson(response,Friend[].class);
                FriendAdapter adapter = new FriendAdapter(friends);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(FriendsActivity.this, "Something error", Toast.LENGTH_SHORT).show();
                Log.d("data","Load error : " + error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(request);
    }
}

