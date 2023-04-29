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

import org.w3c.dom.Text;

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

        MaterialButton nextbtn = (MaterialButton) findViewById(R.id.nextbtn);

        namePerson.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (namePerson.length() == 0 || usernameReg.length() == 0 || (emailReg.length() == 0 && !emailReg.getText().toString().contains("@"))
                        || passwordReg.length() == 0 || confirmPass.length() == 0) {
                    nextbtn.setEnabled(true);
                    if (!passwordReg.getText().toString().equals(confirmPass.getText().toString())) {

                        nextbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(RegisterActivity.this, "Please enter VALID information", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
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
        usernameReg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (namePerson.length() == 0 || usernameReg.length() == 0 || (emailReg.length() == 0 && !emailReg.getText().toString().contains("@"))
                        || passwordReg.length() == 0 || confirmPass.length() == 0) {
                    nextbtn.setEnabled(true);
                    if (!passwordReg.getText().toString().equals(confirmPass.getText().toString())) {

                        nextbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(RegisterActivity.this, "Please enter VALID information", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
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
        emailReg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (namePerson.length() == 0 || usernameReg.length() == 0 || (emailReg.length() == 0 && !emailReg.getText().toString().contains("@"))
                        || passwordReg.length() == 0 || confirmPass.length() == 0) {
                    nextbtn.setEnabled(true);
                    if (!passwordReg.getText().toString().equals(confirmPass.getText().toString())) {

                        nextbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(RegisterActivity.this, "Please enter VALID information", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
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
                if (namePerson.length() == 0 || usernameReg.length() == 0 || (emailReg.length() == 0 && !emailReg.getText().toString().contains("@"))
                        || passwordReg.length() == 0 || confirmPass.length() == 0) {
                    nextbtn.setEnabled(true);
                    if (!passwordReg.getText().toString().equals(confirmPass.getText().toString())) {

                        nextbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(RegisterActivity.this, "Please enter VALID information", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
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
        confirmPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (namePerson.length() == 0 || usernameReg.length() == 0 || (emailReg.length() == 0 && !emailReg.getText().toString().contains("@"))
                        || passwordReg.length() == 0 || confirmPass.length() == 0) {
                    nextbtn.setEnabled(true);
                    if (!passwordReg.getText().toString().equals(confirmPass.getText().toString())) {

                        nextbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(RegisterActivity.this, "Please enter VALID information", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
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