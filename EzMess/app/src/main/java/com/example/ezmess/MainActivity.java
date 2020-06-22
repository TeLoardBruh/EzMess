package com.example.ezmess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getSupportActionBar().hide(); // hide the title bar
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
//        Fresco.initialize(this);

        setContentView(R.layout.activity_startup);
        Button login = (Button) findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Activity_Login.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button signup = (Button) findViewById(R.id.button_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Activity_SignUp.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }

//    public void  onButtonLogin(View view){
//
//        Intent login_page = new Intent(this, Activity_Login.class);
//        startActivity(login_page);
//    }
//    public  void onButtonSignUp(View view){
////enable full screen
//        Intent signUp_page = new Intent(this, Activity_SignUp.class);
//        startActivity(signUp_page);
//    }

}
