package com.appdoptame.appdoptame.Base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.appdoptame.appdoptame.Auth.Login;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Unless there's a heavy load, no handler/delayer is needed
        Intent intent = new Intent(SplashActivity.this, Login.class);
        startActivity(intent);
        finish();
    }
}
