package com.example.mobilcar;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        TextView usernameLog = (TextView) findViewById(R.id.usernameLog);
        TextView emailLog = (TextView) findViewById(R.id.emailLog);
        TextView passwordLog = (TextView) findViewById(R.id.passwordLog);


        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        MaterialButton registerbtn = (MaterialButton) findViewById(R.id.registerbtn);

        usernameLog.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ((emailLog.length() > 0 && passwordLog.length() >= 3) || (usernameLog.length() >= 3 && passwordLog.length() >= 3)) {
                    loginbtn.setEnabled(true);
                } else {
                    loginbtn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        passwordLog.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ((emailLog.length() > 0 && passwordLog.length() >= 3) || (usernameLog.length() >= 3 && passwordLog.length() >= 3)) {
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
                if ((emailLog.length() > 0 && passwordLog.length() >= 3) || (usernameLog.length() >= 3 && passwordLog.length() >= 3)) {
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
                String username = usernameLog.getText().toString().trim();
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                DocumentReference docRef = db.collection("owners").document(email);
                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                            } else {
                                Log.d(TAG, "No such document");
                            }
                        } else {
                            Log.d(TAG, "get failed with ", task.getException());
                        }
                    }
                });
//                FirebaseFirestore db = FirebaseFirestore.getInstance();
//                DocumentReference docRef = db.collection("owners").document(email);
//                docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                    @Override
//                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                        Owner owner = documentSnapshot.toObject(Owner.class);
//                        if(owner.getEmail().equals(email) && owner.getPassword().equals(password)){
//                            Intent intent = new Intent(LoginActivity.this, PersonInfoMainPage.class);
//                            startActivity(intent);
//                        }
//                        else if(owner.getUsername().equals(username) && owner.getPassword().equals(password)){
//                            Intent intent = new Intent(LoginActivity.this, PersonInfoMainPage.class);
//                            startActivity(intent);
//                        }
//                        else if(owner.getUsername().equals(username) && owner.getPassword().equals(password) && owner.getEmail().equals(email)){
//                            Intent intent = new Intent(LoginActivity.this, PersonInfoMainPage.class);
//                            startActivity(intent);
//                        }
//                    }
//                });
//                if (usernameLog.getText().toString().equals("viki") && passwordLog.getText().toString().equals("1234")) {
//                    Intent intent = new Intent(LoginActivity.this, PersonInfoMainPage.class);
//                    startActivity(intent);
//                }
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
