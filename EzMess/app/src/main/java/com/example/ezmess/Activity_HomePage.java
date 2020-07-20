package com.example.ezmess;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ProgressBar;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;

public class Activity_HomePage extends AppCompatActivity  {
    RecyclerView recyclerView ;
    private ProgressBar progressBar;
    private MessageAdapter.RecyclerViewClickListener listener;
    private Message[] messageList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);

        setContentView(R.layout.activity_homepage);
        progressBar = findViewById(R.id.progress_bar);

        recyclerView =  findViewById(R.id.recylerView);

//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(navlistener);
//
//reference recylerview
//
//setup layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
//
////        set adapter
//
//        Message[] messages = loadMessage();
//        MessageAdapter adapter = new MessageAdapter(messages);
//        recyclerView.setAdapter(adapter);


        loadMessage();


    }
//    bottom nav

//    private BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//            Fragment selectItem = null;
//
//            if (menuItem.getItemId() == R.id.item_bottom_2){
//                selectItem = new SettingFragment();
//            }
//            else if (menuItem.getItemId() == R.id.item_bottom_1){
//                selectItem =  new HomeFragment();
//            }
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
//                    selectItem).commit();
//            return true;
//        }
//
//    };
//    menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.menu, menu);
    return true;

}
    // To detect when user clicked on items of the options menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item_1) {
            Toast.makeText(this, R.string.item_1, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getBaseContext(), FriendsActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.item_2){
            Toast.makeText(this, R.string.item_2, Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.item_3){
            Toast.makeText(this, R.string.item_3, Toast.LENGTH_LONG).show();
        }

        return true;
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
        showLoading(true);

        String url = "https://my.api.mockaroo.com/users.json?key=acfdcda0";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                setOnClickListener();
                Message[] messages = gson.fromJson(response,Message[].class);
                System.out.println(messages);
                MessageAdapter adapter = new MessageAdapter(messages, listener);
//                System.out.println(adapter);
                recyclerView.setAdapter(adapter);
                showLoading(false);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Activity_HomePage.this, "Something error", Toast.LENGTH_SHORT).show();
                Log.d("data","Load error : " + error.getMessage());
                showLoading(false);
            }
        });
        Volley.newRequestQueue(this).add(request);
    }

    private void setOnClickListener() {
        this.listener = new MessageAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int i) {

                Intent intent = new Intent(getBaseContext(), Activity_ChatRoom.class);
                startActivity(intent);

            }
        };
    }

    private void showLoading(boolean state){
        if(state){
            recyclerView.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }


}
