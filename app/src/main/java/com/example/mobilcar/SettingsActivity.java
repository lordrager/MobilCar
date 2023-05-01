package com.example.mobilcar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        MaterialButton log_outbtn = (MaterialButton) findViewById(R.id.log_out);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if(id == R.id.sweethome) {
                Intent intent1 = new Intent(SettingsActivity.this, PersonInfoMainPage.class);
                startActivity(intent1);
            } else if (id == R.id.myCar) {
                Intent intent3 = new Intent(SettingsActivity.this, CarProfileActivity.class);
                startActivity(intent3);
            } else if (id == R.id.maps) {
                Intent intent2 = new Intent(SettingsActivity.this, GoogleMapsActivity.class);
                startActivity(intent2);
            } else if (id == R.id.settings) {


            }
            return true;
        });

        log_outbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth fAuth;
                fAuth = FirebaseAuth.getInstance();
                fAuth.signOut();
                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}