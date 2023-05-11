package com.example.mobilcar.Database.FirebaseDatabase;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mobilcar.Models.Classes.TechReview;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FireBaseTechService {

    public void addTech(TechReview techReview, String model) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> instance = new HashMap<>();
        instance.put("Name", techReview.getName());
        instance.put("Start_date", techReview.getStart_date());
        instance.put("End_date", techReview.getEnd_date());
        instance.put("Price", techReview.getPrice());

        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();

        db.collection("owners").document(Objects.requireNonNull(fAuth.getUid())).collection("cars").document(model).collection("tech").document(techReview.getName())
                .set(techReview)
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

    public void updateTech(TechReview techReview, String model) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();
        db.collection("owners").document(Objects.requireNonNull(fAuth.getUid())).collection("cars").document(model).collection("tech").document()
                .update(
                        "name", techReview.getName(),
                        "start_date", techReview.getStart_date(),
                        "end_date", techReview.getEnd_date(),
                        "price", techReview.getPrice()
                );
    }

    public void deleteTech(String model) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();
        db.collection("owners").document(Objects.requireNonNull(fAuth.getUid())).collection("cars").document(model).collection("tech").document()
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
