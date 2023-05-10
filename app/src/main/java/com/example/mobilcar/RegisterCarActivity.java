package com.example.mobilcar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilcar.Database.FirebaseDatabase.FireBaseCarService;
import com.example.mobilcar.Models.Classes.Car;
import com.example.mobilcar.Services.Utils;
import com.google.android.material.button.MaterialButton;

public class RegisterCarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_car_activity);

        TextView markLog = (TextView) findViewById(R.id.brandCar);
        TextView modelLog = (TextView) findViewById(R.id.modelCar);
        TextView gas_expenseLog = (TextView) findViewById(R.id.gasExpenseCar);
        TextView horseLog = (TextView) findViewById(R.id.horsePowerCar);
        TextView yearLog = (TextView) findViewById(R.id.yearMadeText);

        MaterialButton registerbtn = (MaterialButton) findViewById(R.id.registerbtn);
        MaterialButton back = (MaterialButton) findViewById(R.id.backbtn);
        registerbtn.setVisibility(View.VISIBLE);


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
                if (mark.length() > 3 && model.length() > 2 && gas.length() > 0 && horse.length() > 0) {
                    registerbtn.setVisibility(View.VISIBLE);
                    registerbtn.setEnabled(true);
                } else registerbtn.setEnabled(false);
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
                if (mark.length() > 3 && model.length() > 2 && gas.length() > 0 && horse.length() > 0) {
                    registerbtn.setVisibility(View.VISIBLE);
                    registerbtn.setEnabled(true);
                } else registerbtn.setEnabled(false);
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
                if (mark.length() > 3 && model.length() > 2 && gas.length() > 0 && horse.length() > 0) {
                    registerbtn.setVisibility(View.VISIBLE);
                    registerbtn.setEnabled(true);
                } else registerbtn.setEnabled(false);
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
                if (mark.length() > 3 && model.length() > 2 && gas.length() > 0 && horse.length() > 0) {
                    registerbtn.setVisibility(View.VISIBLE);
                    registerbtn.setEnabled(true);
                } else registerbtn.setEnabled(false);
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
                String year = yearLog.getText().toString().trim();

                if(Utils.isContainsOnlyLetters(mark) && Utils.isContainsOnlyNumbers(gas) && Utils.isContainsOnlyNumbers(horse)){
                    Car car = new Car(mark, model, gas, horse, year);
                    FireBaseCarService carService = new FireBaseCarService();
                    carService.addCar(car);


                    Intent intent = new Intent(RegisterCarActivity.this, PersonInfoMainPage.class);
                    startActivity(intent);
                    Toast.makeText(RegisterCarActivity.this, "NEW CAR ADDED!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RegisterCarActivity.this, "Car model must have only letters and gas and horse power must be integers", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterCarActivity.this, CarProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
