package com.example.mobilcar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilcar.Database.FirebaseDatabase.FireBaseCarService;
import com.example.mobilcar.Database.FirebaseDatabase.FireBaseOwnerService;
import com.example.mobilcar.Models.Classes.Car;
import com.example.mobilcar.Models.Classes.Owner;
import com.google.android.material.button.MaterialButton;

public class RegisterCarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_car_activity);

        TextView markLog = (TextView) findViewById(R.id.brandCar);
        TextView modelLog = (TextView) findViewById(R.id.modelCar);
        TextView gas_expenseLog = (TextView) findViewById(R.id.gasExpense);
        TextView horseLog = (TextView) findViewById(R.id.horsePower);
        MaterialButton registerbtn = (MaterialButton) findViewById(R.id.registerbtn);

        markLog.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String mark = markLog.getText().toString().trim();
                String model = modelLog.getText().toString().trim();
                String gas = gas_expenseLog.getText().toString().trim();
                String horse = horseLog.getText().toString().trim();
                if (mark.length()  > 3 && model.length() > 4 && gas.length() > 0 && horse.length()>0) {
                    registerbtn.setEnabled(true);
                }
                else registerbtn.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        modelLog.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String mark = markLog.getText().toString().trim();
                String model = modelLog.getText().toString().trim();
                String gas = gas_expenseLog.getText().toString().trim();
                String horse = horseLog.getText().toString().trim();
                if (mark.length()  > 3 && model.length() > 4 && gas.length() > 0 && horse.length()>0) {
                    registerbtn.setEnabled(true);
                }
                else registerbtn.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        gas_expenseLog.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String mark = markLog.getText().toString().trim();
                String model = modelLog.getText().toString().trim();
                String gas = gas_expenseLog.getText().toString().trim();
                String horse = horseLog.getText().toString().trim();
                if (mark.length()  > 3 && model.length() > 4 && gas.length() > 0 && horse.length()>0) {
                    registerbtn.setEnabled(true);
                }
                else registerbtn.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        horseLog.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String mark = markLog.getText().toString().trim();
                String model = modelLog.getText().toString().trim();
                String gas = gas_expenseLog.getText().toString().trim();
                String horse = horseLog.getText().toString().trim();
                if (mark.length()  > 3 && model.length() > 4 && gas.length() > 0 && horse.length()>0) {
                    registerbtn.setEnabled(true);
                }
                else registerbtn.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mark = markLog.getText().toString().trim();
                String model = modelLog.getText().toString().trim();
                String gas = gas_expenseLog.getText().toString().trim();
                String horse = horseLog.getText().toString().trim();
                Car car = new Car(mark.concat(model).concat(horse), mark, model, Integer.parseInt(gas), Integer.parseInt(horse));
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    String name = extras.getString("name");
                    String username = extras.getString("username");
                    String email = extras.getString("email");
                    String password = extras.getString("password");
                    Owner owner = new Owner(username.concat(email),name, username, email, password,car);
                    FireBaseOwnerService ownerService = new FireBaseOwnerService();
                    FireBaseCarService carService = new FireBaseCarService();
                    ownerService.addOwner(owner);
                    carService.addCar(car);
                }
            }
        });
    }
}
