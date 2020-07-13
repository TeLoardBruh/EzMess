package com.example.ezmess;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Activity_Login extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        Button homepage = (Button) findViewById(R.id.login_loginpage);
        homepage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Activity_HomePage.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }

//    public void  onButtonHomePage(View view){
//
//        Intent home_page = new Intent(this, Activity_HomePage.class);
//        startActivity(home_page);
//    }
}
