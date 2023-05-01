package com.example.mobilcar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PersonInfoMainPage extends AppCompatActivity {


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