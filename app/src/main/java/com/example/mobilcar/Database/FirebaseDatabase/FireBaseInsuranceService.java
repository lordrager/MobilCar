package com.example.mobilcar.Database.FirebaseDatabase;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mobilcar.Models.Classes.LiabilityInsurance;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FireBaseInsuranceService {
    public void addInsurance(LiabilityInsurance insurance) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> instance = new HashMap<>();
        instance.put("Name", insurance.getName());
        instance.put("Start_date", insurance.getStart_date());
        instance.put("End_date", insurance.getEnd_date());
        instance.put("Price", insurance.getPrice());

        db.collection("insurances").document(insurance.getName())
                .set(insurance)
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

    public void updateInsurance(LiabilityInsurance insurance) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> instance = new HashMap<>();
        instance.put("Name", insurance.getName());
        instance.put("Start_date", insurance.getStart_date());
        instance.put("End_date", insurance.getEnd_date());
        instance.put("Price", insurance.getPrice());

        db.collection("insurances").document(insurance.getName())
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

    public void deleteInsurance(String name) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("insurances").document(name)
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
