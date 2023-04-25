package com.example.mobilcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void button_next(View view){
        Toast.makeText(this,"next button", Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(MainActivity.this, DemoActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

}