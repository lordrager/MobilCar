package com.example.mobilcar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilcar.Models.Classes.Owner;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class PersonInfoMainPage extends AppCompatActivity {
    @Override
    protected void onStart()
    {
        super.onStart();
        TextView name = (TextView) findViewById(R.id.nameLogged);
        TextView city = (TextView) findViewById(R.id.cityOfLogged);
        TextView email = (TextView) findViewById(R.id.emailUser);
        TextView username = (TextView) findViewById(R.id.usernameUser);

        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("owners").document(Objects.requireNonNull(fAuth.getUid()));
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Owner owner = documentSnapshot.toObject(Owner.class);
                assert owner != null;
                name.setText(owner.getName());
                email.setText(owner.getEmail());
                username.setText(owner.getUsername());
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info_main_page);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.sweethome) {

            } else if (id == R.id.myCar) {
                Intent intent1 = new Intent(PersonInfoMainPage.this, CarProfileActivity.class);
                startActivity(intent1);
            } else if (id == R.id.maps) {
                Intent intent2 = new Intent(PersonInfoMainPage.this, GoogleMapsActivity.class);
                startActivity(intent2);
            } else if (id == R.id.settings) {
                Intent intent3 = new Intent(PersonInfoMainPage.this, SettingsActivity.class);
                startActivity(intent3);

            }
            return true;
        });


    }
}