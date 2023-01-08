package com.example.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainfeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainfeed_activity);
    }

    public void profileLink(View view) {
        Intent Profile = new Intent(this, ProfileActivity.class);
        startActivity(Profile);
    }

    public void activeCamera(View view) {
        Intent Camera = new Intent(this, CameraActivity.class);
        startActivity(Camera);
    }

}