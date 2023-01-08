package com.example.mobileproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {

    EditText email_login;
    EditText password_login;
    TextView signup_instead;
    Button btnLogin;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        email_login = (EditText) findViewById(R.id.email_field_login);
        password_login = (EditText) findViewById(R.id.password_field_login);
        signup_instead = (TextView) findViewById(R.id.no_account);
        btnLogin = (Button) findViewById(R.id.login_button);
        mAuth = FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(view -> {
            loginUser();
        });
        signup_instead.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            finish();
        });

    }

    private void loginUser(){
        String email = email_login.getText().toString();
        String password = password_login.getText().toString();

        if (TextUtils.isEmpty(email)){
            email_login.setError("Email cannot be empty");
            email_login.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            password_login.setError("Password cannot be empty");
            password_login.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainfeedActivity.class));
                        finish();
                    }else {
                        Toast.makeText(LoginActivity.this, "Log in Error: "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}