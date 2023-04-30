package com.example.mobilcar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CarProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_profile);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
        Button floatingActionButton = findViewById(R.id.addCarsbtn);

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
}