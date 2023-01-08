package com.example.mobileproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class SignupActivity extends AppCompatActivity {

    EditText email_signup;
    EditText password_signup;
    EditText fullname_signup;
    EditText username_signup;
    EditText phonenumber_signup;
    TextView login_instead;
    Button btnRegister;

    FirebaseAuth mAuth;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        fullname_signup = (EditText) findViewById(R.id.fullname_field_signup);
        email_signup = (EditText) findViewById(R.id.email_field_signup);
        password_signup = (EditText) findViewById(R.id.password_field_signup);
        username_signup = (EditText) findViewById(R.id.username_field_signup);
        phonenumber_signup = (EditText) findViewById(R.id.phonenumber_field_signup);
        btnRegister = (Button) findViewById(R.id.sign_up_button);
        login_instead = (TextView) findViewById(R.id.have_account);
        mAuth = FirebaseAuth.getInstance();
        btnRegister.setOnClickListener(view -> createUser());
        login_instead.setOnClickListener(view -> {
            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            finish();
        });

    }
    private void createUser() {
        String fullname = fullname_signup.getText().toString();
        String username = username_signup.getText().toString();
        String email = email_signup.getText().toString();
        String phonenumber = phonenumber_signup.getText().toString();
        String password = password_signup.getText().toString();

        if (TextUtils.isEmpty(fullname)){
            fullname_signup.setError("Full Name cannot be empty");
            fullname_signup.requestFocus();
        }else if (TextUtils.isEmpty(username)){
            username_signup.setError("Username cannot be empty");
            username_signup.requestFocus();
        }else if (TextUtils.isEmpty(email)) {
            email_signup.setError("Email cannot be empty");
            email_signup.requestFocus();
        }else if (TextUtils.isEmpty(phonenumber)){
            phonenumber_signup.setError("Phone Number cannot be empty");
            phonenumber_signup.requestFocus();
        }else if (TextUtils.isEmpty(password)) {
            password_signup.setError("Password cannot be empty");
            password_signup.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(SignupActivity.this, "User registered Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignupActivity.this, MainfeedActivity.class));
                }else{
                    Toast.makeText(SignupActivity.this, "Registration Error: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}