package com.example.mobilcar;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mobilcar.Database.FirebaseDatabase.FireBaseCarService;
import com.example.mobilcar.Models.Classes.Car;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class CarInformationActivity extends AppCompatActivity {

    @Override
    protected void onStart()
    {
        super.onStart();
        Intent getModel = getIntent();
        String modelString;
        modelString = getModel.getStringExtra("Car_Model");

        EditText brand = (EditText) findViewById(R.id.brandCar);
        EditText model = (EditText) findViewById(R.id.modelCar);
        EditText gas_per_km = (EditText) findViewById(R.id.gasCar);
        EditText horse_power = (EditText) findViewById(R.id.horseCar);


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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_information);


        Button savebtn = (Button) findViewById(R.id.save);
        Button deletebtn = (Button) findViewById(R.id.delete);
        Button addtechbtn = (Button) findViewById(R.id.techbtn);
        Button addLiablitybtn = (Button) findViewById(R.id.liabtn);

//        EditText brand = (EditText) findViewById(R.id.brandCar);
//        EditText model = (EditText) findViewById(R.id.modelCar);
//        EditText gas_per_km = (EditText) findViewById(R.id.gasCar);
//        EditText horse_power = (EditText) findViewById(R.id.horseCar);
//
//
//        FirebaseAuth fAuth;
//        fAuth = FirebaseAuth.getInstance();
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//
//        DocumentReference docRef = db.collection("owners").document(Objects.requireNonNull(fAuth.getUid())).collection("cars").document(modelString);
//        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//                    if (document.exists()) {
//                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
//                        Car car = document.toObject(Car.class);
//                        brand.setText(car.getBrand());
//                        model.setText(car.getModel());
//                        gas_per_km.setText(car.getGas_per_km());
//                        horse_power.setText(car.getHorse_power());
//
//                    } else {
//                        Log.d(TAG, "No such document");
//                    }
//                } else {
//                    Log.d(TAG, "get failed with ", task.getException());
//                }
//            }
//        });


        addtechbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarInformationActivity.this, TechReviewActivity.class);
                Intent getModel = getIntent();
                String modelString;
                modelString = getModel.getStringExtra("Car_Model");
                intent.putExtra("Car_Model",modelString);
                startActivity(intent);
            }
        });

        addLiablitybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarInformationActivity.this, LiabilityInsuranceActivity.class);
                Intent getModel = getIntent();
                String modelString;
                modelString = getModel.getStringExtra("Car_Model");
                intent.putExtra("Car_Model",modelString);
                startActivity(intent);
            }
        });

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText brand = (EditText) findViewById(R.id.brandCar);
                EditText model = (EditText) findViewById(R.id.modelCar);
                EditText gas_per_km = (EditText) findViewById(R.id.gasCar);
                EditText horse_power = (EditText) findViewById(R.id.horseCar);

                String newbrand = brand.getText().toString().trim();
                String newmodel = model.getText().toString().trim();
                String newgas_per_km = gas_per_km.getText().toString().trim();
                String newhorse_power = horse_power.getText().toString().trim();

                Intent getModel = getIntent();
                String modelString;
                modelString = getModel.getStringExtra("Car_Model");
                FireBaseCarService fireBaseCarService = new FireBaseCarService();
                Car car = new Car(newbrand,newmodel,newgas_per_km,newhorse_power);
                fireBaseCarService.updateCar(car, modelString);
                Intent intent = new Intent(CarInformationActivity.this, CarProfileActivity.class);
                startActivity(intent);
            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getModel = getIntent();
                String modelString;
                modelString = getModel.getStringExtra("Car_Model");
                FireBaseCarService fireBaseCarService = new FireBaseCarService();
                fireBaseCarService.deleteCar(modelString);
                Intent intent = new Intent(CarInformationActivity.this, CarProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}

