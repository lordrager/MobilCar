package com.example.mobilcar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterCarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_car_activity);

        TextView brand = (TextView) findViewById(R.id.brandCar);
        TextView model = (TextView) findViewById(R.id.modelCar);
        TextView gasExpense = (TextView) findViewById(R.id.gasExpense);
        TextView horsePower = (TextView) findViewById(R.id.horsePower);

        Button addMorebtn = (Button) findViewById(R.id.addMorebtn);
        Button finishbtn = (Button) findViewById(R.id.finishbtn);

        addMorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterCarActivity.this, RegisterCarActivity.class);
                startActivity(intent);
            }
        });

        finishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterCarActivity.this, CarProfileActivity.class);
                startActivity(intent);
            }
        });

    }
}
