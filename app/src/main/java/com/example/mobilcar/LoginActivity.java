package com.example.mobilcar;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();

        FirebaseUser user = fAuth.getCurrentUser();

        if(Objects.nonNull(user) && user.isEmailVerified()) {
            Intent intent = new Intent(LoginActivity.this, PersonInfoMainPage.class);
            startActivity(intent);
        }

        TextView emailLog = (TextView) findViewById(R.id.emailLog);
        TextView passwordLog = (TextView) findViewById(R.id.passwordLog);


        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        MaterialButton registerbtn = (MaterialButton) findViewById(R.id.registerbtn);



        passwordLog.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (emailLog.length() > 0 && passwordLog.length() >= 3) {
                    loginbtn.setEnabled(true);
                } else {
                    loginbtn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        emailLog.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (emailLog.length() > 0 && passwordLog.length() >= 3) {
                    loginbtn.setEnabled(true);
                } else {
                    loginbtn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //viki and 1234

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailLog.getText().toString().trim();
                String password = passwordLog.getText().toString().trim();

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            boolean isVerified = Objects.requireNonNull(fAuth.getCurrentUser()).isEmailVerified();
                            if(isVerified) {
                                Intent intent = new Intent(LoginActivity.this, PersonInfoMainPage.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(LoginActivity.this, "Please verify.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
