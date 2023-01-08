package com.example.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CameraActivity extends AppCompatActivity {
    Button btnCam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_activity);
        btnCam=(Button) findViewById(R.id.btnCam);
        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
                   Intent intent = new Intent();
                   intent.setAction((MediaStore.ACTION_IMAGE_CAPTURE));
                   startActivity(intent);
               } catch (Exception e )
               {
                   e.printStackTrace();
               }

            }
        });


        }
    public void profileLink(View view) {
        Intent Profile = new Intent(this, ProfileActivity.class);
        startActivity(Profile);
    }
    }

