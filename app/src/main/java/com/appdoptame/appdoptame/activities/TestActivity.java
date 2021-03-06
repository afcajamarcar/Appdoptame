package com.appdoptame.appdoptame.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.appdoptame.appdoptame.R;
import com.appdoptame.appdoptame.fragments.PostFragment;
import com.facebook.login.LoginManager;
import com.appdoptame.appdoptame.Auth.Login;
import com.google.firebase.auth.FirebaseAuth;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        savedInstanceState = getIntent().getExtras();
        if(!checkForUser()) goLoginScreen();
        super.onCreate(savedInstanceState);
        if(checkForUser()) goUploadScreen(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(!checkForUser()) goLoginScreen();
    }

    private void goLoginScreen(){
        Intent intent = new Intent(this, Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void goUploadScreen(Bundle savedInstanceState){
        String user = savedInstanceState.getString("Username");
        Intent intent = new Intent(this, PostFragment.class);
        intent.putExtra("Username", user);
        startActivity(intent);
    }

    private Boolean checkForUser(){
        return FirebaseAuth.getInstance().getCurrentUser() == null ? false : true;
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
        try{
            Intent out = new Intent(this, Login.class);
            startActivity(out);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
