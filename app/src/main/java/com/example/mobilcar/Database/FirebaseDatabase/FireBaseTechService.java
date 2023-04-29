package com.example.mobilcar.Database.FirebaseDatabase;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mobilcar.Models.Classes.TechReview;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FireBaseTechService {

    public void addRech(TechReview techReview) {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Map<String, Object> instance = new HashMap<>();
    instance.put("Name", techReview.getName());
    instance.put("Start_date", techReview.getStart_date());
    instance.put("End_date", techReview.getEnd_date());
    instance.put("Price", techReview.getPrice());

    db.collection("techs").document(techReview.getName())
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

    public void updateTech(TechReview techReview){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> instance = new HashMap<>();
        instance.put("Name", techReview.getName());
        instance.put("Start_date", techReview.getStart_date());
        instance.put("End_date", techReview.getEnd_date());
        instance.put("Price", techReview.getPrice());

        db.collection("techs").document(techReview.getName())
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

    public void deleteTech(String name){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("techs").document(name)
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
