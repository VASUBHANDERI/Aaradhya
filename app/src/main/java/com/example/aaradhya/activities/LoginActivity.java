package com.example.aaradhya.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aaradhya.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

    }

    public void SignIn(View view) {

        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();


        if (TextUtils.isEmpty(userEmail)){

            Toast.makeText(this,"Enter Email Address!",Toast.LENGTH_SHORT).show();
            return;

        }
        if (TextUtils.isEmpty(userPassword)){

            Toast.makeText(this,"Enter Password!",Toast.LENGTH_SHORT).show();
            return;

        }
        if (userPassword.length() < 6) {

            Toast.makeText(this,"Password is too short, enter minimum 6 characters!",Toast.LENGTH_SHORT).show();
            return;

        }

        mAuth.signInWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){

                            Toast.makeText(LoginActivity.this, "SignIn Successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));

                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Invalid Email or Password"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });



    }

    public void signup(View view) {

        startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));

    }
}