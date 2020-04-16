package com.example.ezmess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  onButtonLogin(View view){
        Intent login_page = new Intent(this, Activity_Login.class);
        startActivity(login_page);

    }
    public  void onButtonSignUp(View view){
        Intent signUp_page = new Intent(this, Activity_SignUp.class);
        startActivity(signUp_page);
    }

}
