package com.example.mobilcar.Database.FirebaseDatabase;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mobilcar.Models.Classes.Owner;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FireBaseOwnerService {

    public void addOwner(Owner owner) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> instance = new HashMap<>();
        instance.put("Name", owner.getName());
        instance.put("Username", owner.getUsername());
        instance.put("Email", owner.getUsername());
        instance.put("Password", owner.getPassword());

//        instance.put("Car", owner.getCars());

        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();

        db.collection("owners").document(Objects.requireNonNull(fAuth.getUid()))
                .set(owner)
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

    public Owner getOwner(){
        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("owners").document(Objects.requireNonNull(fAuth.getUid()));
        final Owner[] owner = new Owner[1];
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                owner[0] = documentSnapshot.toObject(Owner.class);
            }
        });
        return owner[0];
    }

    public void updateOwner(Owner owner){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> instance = new HashMap<>();
        instance.put("Name", owner.getName());
        instance.put("Username", owner.getUsername());
        instance.put("Email", owner.getUsername());
        instance.put("Password", owner.getPassword());
//        instance.put("Car", owner.getCars());


        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();
//        instance.put("Location", owner.getLocation());

        db.collection("owners").document(Objects.requireNonNull(fAuth.getUid()))
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

    public void deleteOwner(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();
        db.collection("owners").document(Objects.requireNonNull(fAuth.getUid()))
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