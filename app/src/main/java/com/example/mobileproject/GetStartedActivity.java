package com.example.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class GetStartedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getstarted_activity);
        setTitle("Welcome !");
    }
    public void onGetstartedBtnClicked(View view) {
        Intent Login = new Intent(this, LoginActivity.class);
        startActivity(Login);
        finish();
    }
}
