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

import com.example.mobilcar.Database.FirebaseDatabase.FireBaseOwnerService;
import com.example.mobilcar.Models.Classes.Owner;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);


        TextView namePerson = (TextView) findViewById(R.id.namePerson);
        TextView usernameReg = (TextView) findViewById(R.id.usernameReg);
        TextView emailReg = (TextView) findViewById(R.id.emailReg);
        TextView passwordReg = (TextView) findViewById(R.id.passwordReg);
        TextView confirmPass = (TextView) findViewById(R.id.confirmPass);
        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();

        MaterialButton nextbtn = (MaterialButton) findViewById(R.id.nextbtn);
        MaterialButton backbtn = (MaterialButton) findViewById(R.id.backbtn);

        namePerson.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = emailReg.getText().toString().trim();
                String password = passwordReg.getText().toString().trim();
                String conpassword = confirmPass.getText().toString().trim();
                String name = namePerson.getText().toString().trim();
                String username = usernameReg.getText().toString().trim();
                if (name.length() > 3 && username.length() > 4 && email.length() > 4 && password.length() > 5 && conpassword.length() > 5) {
                    if (email.contains("@"))
                        nextbtn.setEnabled(true);
                    else nextbtn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        usernameReg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = emailReg.getText().toString().trim();
                String password = passwordReg.getText().toString().trim();
                String conpassword = confirmPass.getText().toString().trim();
                String name = namePerson.getText().toString().trim();
                String username = usernameReg.getText().toString().trim();
                if (name.length() > 3 && username.length() > 4 && email.length() > 4 && password.length() > 5 && conpassword.length() > 5) {
                    if (email.contains("@"))
                        nextbtn.setEnabled(true);
                    else nextbtn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        emailReg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = emailReg.getText().toString().trim();
                String password = passwordReg.getText().toString().trim();
                String conpassword = confirmPass.getText().toString().trim();
                String name = namePerson.getText().toString().trim();
                String username = usernameReg.getText().toString().trim();
                if (name.length() > 3 && username.length() > 4 && email.length() > 4 && password.length() > 5 && conpassword.length() > 5) {
                    if (email.contains("@"))
                        nextbtn.setEnabled(true);
                    else nextbtn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        passwordReg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = emailReg.getText().toString().trim();
                String password = passwordReg.getText().toString().trim();
                String conpassword = confirmPass.getText().toString().trim();
                String name = namePerson.getText().toString().trim();
                String username = usernameReg.getText().toString().trim();
                if (name.length() > 3 && username.length() > 4 && email.length() > 4 && password.length() > 5 && conpassword.length() > 5) {
                    if (email.contains("@"))
                        nextbtn.setEnabled(true);
                    else nextbtn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        confirmPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = emailReg.getText().toString().trim();
                String password = passwordReg.getText().toString().trim();
                String conpassword = confirmPass.getText().toString().trim();
                String name = namePerson.getText().toString().trim();
                String username = usernameReg.getText().toString().trim();
                if (name.length() > 3 && username.length() > 4 && email.length() > 4 && password.length() > 5 && conpassword.length() > 5) {
                    if (email.contains("@"))
                        nextbtn.setEnabled(true);
                    else nextbtn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = namePerson.getText().toString().trim();
                String username = usernameReg.getText().toString().trim();
                String email = emailReg.getText().toString().trim();
                String password = passwordReg.getText().toString().trim();


                fAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");

                                    FirebaseUser user = fAuth.getCurrentUser();
                                    if (Objects.nonNull(user)) {
                                        user.sendEmailVerification();
                                    }

                                    FireBaseOwnerService ownerService = new FireBaseOwnerService();
                                    Owner owner = new Owner(name, username, email, password);
                                    ownerService.addOwner(owner);

                                    Toast.makeText(RegisterActivity.this, "Verify email.",
                                            Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                } else {
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}