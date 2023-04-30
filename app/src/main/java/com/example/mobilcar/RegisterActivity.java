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
                String email = emailReg.getText().toString().trim();
                String password = passwordReg.getText().toString().trim();
                String conpassword = confirmPass.getText().toString().trim();
                String name = namePerson.getText().toString().trim();
                String username = usernameReg.getText().toString().trim();
                if (name.length()  > 3 && username.length() > 4 && email.length() > 4 && password.length()  > 5 && conpassword.length() > 5) {
                    if(email.contains("@"))
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
                if (name.length()  > 3 && username.length() > 4 && email.length() > 4 && password.length()  > 5 && conpassword.length() > 5) {
                    if(email.contains("@"))
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
                if (name.length()  > 3 && username.length() > 4 && email.length() > 4 && password.length()  > 5 && conpassword.length() > 5) {
                    if(email.contains("@"))
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
                if (name.length()  > 3 && username.length() > 4 && email.length() > 4 && password.length()  > 5 && conpassword.length() > 5) {
                    if(email.contains("@"))
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
                if (name.length()  > 3 && username.length() > 4 && email.length() > 4 && password.length()  > 5 && conpassword.length() > 5) {
                    if(email.contains("@"))
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
//                FireBaseOwnerService ownerService = new FireBaseOwnerService();
//                Owner owner = new Owner(username.concat(email),name, username, email, password);
//                ownerService.addOwner(owner);
                Intent intent = new Intent(RegisterActivity.this, RegisterCarActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("username", username);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                startActivity(intent);
                Toast.makeText(RegisterActivity.this, "WELCOME NEW USER", Toast.LENGTH_SHORT).show();
            }
        });
    }
}