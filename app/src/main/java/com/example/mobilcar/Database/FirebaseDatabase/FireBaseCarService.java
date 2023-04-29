package com.example.mobilcar.Database.FirebaseDatabase;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mobilcar.Models.Classes.Car;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FireBaseCarService {
    public void addCar(Car car) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> instance = new HashMap<>();
        instance.put("Brand", car.getBrand());
        instance.put("Model", car.getModel());
        instance.put("Year_made", car.getYear_made());
        instance.put("Gas_per_km", car.getGas_per_km());
        instance.put("Horse_power", car.getHorse_power());
        instance.put("TechReview", car.getTechReview());
        instance.put("LiabilityInsurance", car.getLiabilityInsurance());

        db.collection("cars").document(car.getModel())
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

    public void updateCar(Car car){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> instance = new HashMap<>();
        instance.put("Brand", car.getBrand());
        instance.put("Model", car.getModel());
        instance.put("Year_made", car.getYear_made());
        instance.put("Gas_per_km", car.getGas_per_km());
        instance.put("Horse_power", car.getHorse_power());
        instance.put("TechReview", car.getTechReview());
        instance.put("LiabilityInsurance", car.getLiabilityInsurance());

        db.collection("cars").document(car.getModel())
                .set(instance)
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

    public void deleteCar(String model){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("cars").document(model)
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
