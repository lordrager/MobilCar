package com.example.mobilcar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilcar.Models.Classes.Car;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarProfileActivity extends AppCompatActivity {

    ListView carsLV;
    ArrayList<Car> carsArrayList;
    FirebaseFirestore db;

    @Override
    protected void onStart()
    {
        super.onStart();
        carsLV = findViewById(R.id.carsList);
        carsArrayList = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        loadDataInListview();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_profile);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
        Button floatingActionButton = findViewById(R.id.addCarsbtn);

//        carsLV = findViewById(R.id.carsList);
//        carsArrayList = new ArrayList<>();
//        db = FirebaseFirestore.getInstance();
//        loadDataInListview();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarProfileActivity.this, RegisterCarActivity.class);
                startActivity(intent);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.sweethome) {
                Intent intent1 = new Intent(CarProfileActivity.this, PersonInfoMainPage.class);
                startActivity(intent1);
            } else if (id == R.id.myCar) {

            } else if (id == R.id.maps) {
                Intent intent2 = new Intent(CarProfileActivity.this, GoogleMapsActivity.class);
                startActivity(intent2);
            } else if (id == R.id.settings) {
                Intent intent3 = new Intent(CarProfileActivity.this, SettingsActivity.class);
                startActivity(intent3);

            }
            return true;
        });
    }
    private void loadDataInListview() {
        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();
        FirebaseUser user = fAuth.getCurrentUser();



        db.collection("owners").document(Objects.requireNonNull(fAuth.getUid())).collection("cars").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                Car carModal = new Car((String) d.get("brand"), (String) d.get("model"), (String) d.get("horse_power"), (String) d.get("gas_per_km"));
                                carsArrayList.add(carModal);
                            }
                            CarListAdapter adapter = new CarListAdapter(CarProfileActivity.this, carsArrayList);
                            carsLV.setAdapter(adapter);

                        } else {
                            Toast.makeText(CarProfileActivity.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CarProfileActivity.this, "Fail to load data..", Toast.LENGTH_SHORT).show();
                    }
                });



    }
}