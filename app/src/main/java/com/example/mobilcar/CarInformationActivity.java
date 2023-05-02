package com.example.mobilcar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilcar.Models.Classes.Car;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class CarInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_information);

        Intent getModel = getIntent();
        String modelStirng;
        modelStirng = getModel.getStringExtra("Car_Model");

//        MaterialButton addtechbtn = (MaterialButton) findViewById(R.id.add_Techbtn);
//        MaterialButton addLiablitybtn = (MaterialButton) findViewById(R.id.add_Liablitybtn);

        TextView brand = (TextView) findViewById(R.id.brandCar);
        TextView model = (TextView) findViewById(R.id.modelCar);
        TextView gas_per_km = (TextView) findViewById(R.id.gasCar);
        TextView horse_power = (TextView) findViewById(R.id.horseCar);


        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("owners").document(fAuth.getUid()).collection("cars").document(modelStirng);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Car car = documentSnapshot.toObject(Car.class);
            }
        });

//        addtechbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(CarInformationActivity.this, TechReviewActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        addLiablitybtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(CarInformationActivity.this, TechReviewActivity.class);
////                startActivity(intent);
//            }
//        });
    }
}

