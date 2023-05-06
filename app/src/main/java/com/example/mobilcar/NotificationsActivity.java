package com.example.mobilcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mobilcar.Adapter.EventAdapter;
import com.example.mobilcar.Database.DatabaseClass;
import com.example.mobilcar.Database.EntityClass;

import java.util.List;

public class NotificationsActivity extends AppCompatActivity implements View.OnClickListener {

    Button addNotif;
    RecyclerView recyclerView;
    EventAdapter eventAdapter;
    DatabaseClass databaseClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        addNotif = findViewById(R.id.addNotif);
        addNotif.setOnClickListener(this);
        recyclerView = findViewById(R.id.recyclerview);

    }

    protected void onResume() {
        super.onResume();
        setAdapter();
    }

    private void setAdapter() {
        List<EntityClass> classList = databaseClass.EventDao().getAllData();
        eventAdapter = new EventAdapter(getApplicationContext(), classList);
        recyclerView.setAdapter(eventAdapter);
    }

    @Override
    public void onClick(View view) {

        if (view == addNotif) {
            Intent intent = new Intent(getApplicationContext(), CreateNotification.class);
            startActivity(intent);
        }
    }
}