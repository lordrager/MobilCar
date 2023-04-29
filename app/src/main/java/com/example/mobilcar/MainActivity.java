package com.example.mobilcar;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

//import com.example.mobilcar.Database.OwnerDatabaseHelper;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder alertDialogBuilder;
    AlertDialog alertDialog;

//    final OwnerDatabaseHelper db = new OwnerDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}