package com.example.mobilcar;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilcar.Database.FirebaseDatabase.FireBaseTechService;
import com.example.mobilcar.Models.Classes.TechReview;
import com.example.mobilcar.databinding.ActivityAddTechReviewBinding;
import com.google.android.material.button.MaterialButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TechReviewActivity extends AppCompatActivity {

    private ActivityAddTechReviewBinding binding;
    private Calendar calendar;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddTechReviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CreateNotificationChannel();
//        setContentView(R.layout.activity_add_tech_review);

        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 4); // add 1 month to the current date
        calendar.set(Calendar.DAY_OF_MONTH, 7); // set the day of the month to 15
        calendar.set(Calendar.HOUR_OF_DAY, 0); // set the hour to 12 PM
        calendar.set(Calendar.MINUTE, 31); // set the minute to 0
        calendar.set(Calendar.SECOND, 0);

        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(TechReviewActivity.this, CarProfileActivity.class);
        pendingIntent = PendingIntent.getBroadcast(TechReviewActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
//        long notificationTime = calendar.getTimeInMillis();
//        alarmManager.setExact(AlarmManager.RTC_WAKEUP, notificationTime, PendingIntent.getBroadcast(context, i, intent, PendingIntent.FLAG_UPDATE_CURRENT));

        TextView name = (TextView) findViewById(R.id.name);
        TextView startDate = (TextView) findViewById(R.id.editStartDate);
        TextView endDate = (TextView) findViewById(R.id.editEndDate);
        TextView price = (TextView) findViewById(R.id.addTechPrice);


        MaterialButton confirmDoc = (MaterialButton) findViewById(R.id.add_techreview_btn);
        Button notifbtn = (Button) findViewById(R.id.buttonForNotif);



        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String name1 = name.getText().toString().trim();
                String startD = startDate.getText().toString().trim();
                String endD = endDate.getText().toString().trim();
                String priceD = price.getText().toString().trim();
                if (name1.length() > 0 && startD.length() > 0 && endD.length() > 0 && priceD.length() > 0) {
                    confirmDoc.setEnabled(true);
                } else confirmDoc.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        startDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String name1 = name.getText().toString().trim();
                String startD = startDate.getText().toString().trim();
                String endD = endDate.getText().toString().trim();
                String priceD = price.getText().toString().trim();
                if (name1.length() > 0 && startD.length() > 0 && endD.length() > 0 && priceD.length() > 0) {
                    confirmDoc.setEnabled(true);
                } else confirmDoc.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        endDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String name1 = name.getText().toString().trim();
                String startD = startDate.getText().toString().trim();
                String endD = endDate.getText().toString().trim();
                String priceD = price.getText().toString().trim();
                if (name1.length() > 0 && startD.length() > 0 && endD.length() > 0 && priceD.length() > 0) {
                    confirmDoc.setEnabled(true);
                } else confirmDoc.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String name1 = name.getText().toString().trim();
                String startD = startDate.getText().toString().trim();
                String endD = endDate.getText().toString().trim();
                String priceD = price.getText().toString().trim();
                if (name1.length() > 0 && startD.length() > 0 && endD.length() > 0 && priceD.length() > 0) {
                    confirmDoc.setEnabled(true);
                } else confirmDoc.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        confirmDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTech = name.getText().toString().trim();
                String startDateTech = startDate.getText().toString().trim();
                String endDateTech = endDate.getText().toString().trim();
                String priceTech = price.getText().toString().trim();
                Intent getModel = getIntent();
                String modelString;
                modelString = getModel.getStringExtra("Car_Model");
                Date start;
                Date end;
                try {
                    start=new SimpleDateFormat("dd/MM/yyyy").parse(startDateTech);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                try {
                    end=new SimpleDateFormat("dd/MM/yyyy").parse(endDateTech);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                TechReview techReview = new TechReview(nameTech,start,end,priceTech);
                FireBaseTechService fireBaseTechService = new FireBaseTechService();
                fireBaseTechService.addTech(techReview, modelString);
                Intent intent = new Intent(TechReviewActivity.this, CarProfileActivity.class);
                startActivity(intent);
            }
        });

    }

    private void CreateNotificationChannel(){
        if(Build.VERSION_CODES.O <= Build.VERSION.SDK_INT){
            CharSequence name = "getNewDocumentname";
            String desc = "Channel for Alarm";
            int imp = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("getNewDocument", name, imp);
            channel.setDescription(desc);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
