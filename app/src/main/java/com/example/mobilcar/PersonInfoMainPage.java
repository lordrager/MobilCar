package com.example.mobilcar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mobilcar.Fragments.HomeFragment;
import com.example.mobilcar.Fragments.MapsFragment;
import com.example.mobilcar.Fragments.MyCarFragment;
import com.example.mobilcar.Fragments.SettingsFragment;
import com.example.mobilcar.databinding.ActivityPersonInfoMainPageBinding;

public class PersonInfoMainPage extends AppCompatActivity {

    ActivityPersonInfoMainPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersonInfoMainPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());


        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            int id = item.getItemId();
            if (id == R.id.home) {
                replaceFragment(new HomeFragment());
            } else if (id == R.id.myCar) {
                replaceFragment(new MyCarFragment());
            } else if (id == R.id.maps) {
                replaceFragment(new MapsFragment());
            } else if (id == R.id.settings) {
                replaceFragment(new SettingsFragment());
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}