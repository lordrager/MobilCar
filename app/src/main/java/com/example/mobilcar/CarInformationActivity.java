package com.example.mobilcar;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilcar.Models.Classes.Car;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.example.mobilcar.Models.Classes.LiabilityInsurance;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class CarInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_information);

        Intent getModel = getIntent();
        String modelString;
        modelString = getModel.getStringExtra("Car_Model");

        Button savebtn = (Button) findViewById(R.id.save);
        Button deletebtn = (Button) findViewById(R.id.delete);
        Button addtechbtn = (Button) findViewById(R.id.liabtn);
        Button addLiablitybtn = (Button) findViewById(R.id.techbtn);

        TextView brand = (TextView) findViewById(R.id.brandCar);
        TextView model = (TextView) findViewById(R.id.modelCar);
        TextView gas_per_km = (TextView) findViewById(R.id.gasCar);
        TextView horse_power = (TextView) findViewById(R.id.horseCar);


        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();


        DocumentReference docRef = db.collection("owners").document(Objects.requireNonNull(fAuth.getUid())).collection("cars").document(modelString);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        Car car = document.toObject(Car.class);
                        brand.setText(car.getBrand());
                        model.setText(car.getModel());
                        gas_per_km.setText(car.getGas_per_km());
                        horse_power.setText(car.getHorse_power());

                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });


        addtechbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarInformationActivity.this, TechReviewActivity.class);
                startActivity(intent);
            }
        });

        addLiablitybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarInformationActivity.this, LiabilityInsuranceActivity.class);
                startActivity(intent);
            }
        });
    }
}

