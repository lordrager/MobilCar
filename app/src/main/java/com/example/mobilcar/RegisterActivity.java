package com.example.mobilcar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        TextView usernameReg = (TextView) findViewById(R.id.usernameReg);
        TextView email = (TextView) findViewById(R.id.email);
        TextView egn = (TextView) findViewById(R.id.egn);
        TextView passwordReg = (TextView) findViewById(R.id.passwordReg);

        MaterialButton nextbtn = (MaterialButton) findViewById(R.id.nextbtn);

        usernameReg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (usernameReg.length() == 0 || (email.length() == 0 || !email.getText().toString().contains("@")) || egn.length() != 10 || passwordReg.length() == 0) {
                    nextbtn.setEnabled(true);

                    nextbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(RegisterActivity.this, "Please enter VALID information", Toast.LENGTH_SHORT).show();
                        }
                    });

                } else {
                    nextbtn.setEnabled(true);

                    nextbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            Toast.makeText(RegisterActivity.this, "WELCOME NEW USER", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (usernameReg.length() == 0 || (email.length() == 0 || !email.getText().toString().contains("@")) || egn.length() != 10 || passwordReg.length() == 0) {
                    nextbtn.setEnabled(true);

                    nextbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(RegisterActivity.this, "Please enter VALID information", Toast.LENGTH_SHORT).show();
                        }
                    });

                } else {
                    nextbtn.setEnabled(true);

                    nextbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            Toast.makeText(RegisterActivity.this, "WELCOME NEW USER", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        egn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (usernameReg.length() == 0 || (email.length() == 0 || !email.getText().toString().contains("@")) || egn.length() != 10 || passwordReg.length() == 0) {
                    nextbtn.setEnabled(true);

                    nextbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(RegisterActivity.this, "Please enter VALID information", Toast.LENGTH_SHORT).show();
                        }
                    });

                } else {
                    nextbtn.setEnabled(true);

                    nextbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            Toast.makeText(RegisterActivity.this, "WELCOME NEW USER", Toast.LENGTH_SHORT).show();
                        }
                    });

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
                if (usernameReg.length() == 0 || (email.length() == 0 || !email.getText().toString().contains("@")) || egn.length() != 10 || passwordReg.length() == 0) {
                    nextbtn.setEnabled(true);

                    nextbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(RegisterActivity.this, "Please enter VALID information", Toast.LENGTH_SHORT).show();
                        }
                    });

                } else {
                    nextbtn.setEnabled(true);

                    nextbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            Toast.makeText(RegisterActivity.this, "WELCOME NEW USER", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}