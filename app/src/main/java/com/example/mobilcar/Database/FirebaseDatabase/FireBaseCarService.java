package com.example.mobilcar.Database.FirebaseDatabase;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mobilcar.Models.Classes.Car;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FireBaseCarService {
    public void addCar(Car car) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> instance = new HashMap<>();
        instance.put("brand", car.getBrand());
        instance.put("model", car.getModel());
//        instance.put("Year_made", car.getYear_made());
        instance.put("gas_per_km", car.getGas_per_km());
        instance.put("horse_power", car.getHorse_power());
//        instance.put("TechReview", car.getTechReview());
//        instance.put("LiabilityInsurance", car.getLiabilityInsurance());


        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();

        db.collection("owners").document(Objects.requireNonNull(fAuth.getUid())).collection("cars").document(car.getModel())
                .set(car)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }

//    public void updateCar(Car car, String model){
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        Map<String, Object> instance = new HashMap<>();
//        instance.put("brand", car.getBrand());
//        instance.put("model", car.getModel());
////        instance.put("Year_made", car.getYear_made());
//        instance.put("gas_per_km", car.getGas_per_km());
//        instance.put("horse_power", car.getHorse_power());
//
//        FirebaseAuth fAuth;
//        fAuth = FirebaseAuth.getInstance();
//
//        db.collection("owners").document(Objects.requireNonNull(fAuth.getUid())).collection("cars").document(model)
//                .update(instance)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        Log.d(TAG, "DocumentSnapshot successfully written!");
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "Error writing document", e);
//                    }
//                });
//    }

    public void updateCar(Car car,String model){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> instance = new HashMap<>();
        instance.put("brand", car.getBrand());
        instance.put("model", car.getModel());
//        instance.put("Year_made", car.getYear_made());
        instance.put("gas_per_km", car.getGas_per_km());
        instance.put("horse_power", car.getHorse_power());

        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();
        db.collection("owners").document(Objects.requireNonNull(fAuth.getUid())).collection("cars").document(model)
                .update(
                        "brand", car.getBrand(),
                        "model", car.getModel(),
                        "gas_per_km", car.getGas_per_km(),
                        "horse_power", car.getHorse_power()
                );

    }

    public void deleteCar(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();

        db.collection("owners").document(Objects.requireNonNull(fAuth.getUid())).collection("cars").document()
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully deleted!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error deleting document", e);
                    }
                });
    }

    public void deleteCar(String moodel){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();

        db.collection("owners").document(Objects.requireNonNull(fAuth.getUid())).collection("cars").document(moodel)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully deleted!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error deleting document", e);
                    }
                });
    }
}
