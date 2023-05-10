package com.example.mobilcar;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilcar.Database.FirebaseDatabase.FireBaseInsuranceService;
import com.example.mobilcar.Models.Classes.LiabilityInsurance;
import com.example.mobilcar.databinding.ActivityAddLiabilityInsuranceBinding;
import com.google.android.material.button.MaterialButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LiabilityInsuranceActivity extends AppCompatActivity {
    public static final int MY_PERMISSION_ACCESS_COURSE_LOCATION = 1;
    private ActivityAddLiabilityInsuranceBinding binding;
    private Calendar calendar;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddLiabilityInsuranceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CreateNotificationChannel();
//        setContentView(R.layout.activity_add_tech_review);

        TextView name = (TextView) findViewById(R.id.name);
        TextView startDate = (TextView) findViewById(R.id.editStartDate);
        TextView endDate = (TextView) findViewById(R.id.editEndDate);
        TextView price = (TextView) findViewById(R.id.addLiabilityPrice);


        MaterialButton confirmDoc = (MaterialButton) findViewById(R.id.add_liability_btn);
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

                if (name1.length() > 0 && startD.length() > 0 && endD.length() > 0 && priceD.length() > 0)  {
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

        binding.addLiabilityBtn.setOnClickListener(new View.OnClickListener() {
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
                    end = new SimpleDateFormat("dd/MM/yyyy").parse(endDateTech);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                if(start.compareTo(end)<0){
                    LiabilityInsurance liabilityInsurance = new LiabilityInsurance(nameTech, start, end, priceTech);
                    FireBaseInsuranceService fireBaseInsuranceService = new FireBaseInsuranceService();
                    fireBaseInsuranceService.addInsurance(liabilityInsurance, modelString);
                    calendar = Calendar.getInstance();
                    calendar.add(Calendar.YEAR, end.getYear());
                    calendar.add(Calendar.MONTH, end.getMonth());
                    calendar.set(Calendar.DAY_OF_MONTH, end.getDay());
                    calendar.set(Calendar.HOUR_OF_DAY, 15);
                    calendar.set(Calendar.MINUTE, 55);

                    alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                    Intent Receiveintent = new Intent(LiabilityInsuranceActivity.this, LiabilityInsuranceReceiver.class);
                    pendingIntent = PendingIntent.getBroadcast(LiabilityInsuranceActivity.this, 0, Receiveintent, PendingIntent.FLAG_IMMUTABLE);
                    alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                            AlarmManager.INTERVAL_DAY, pendingIntent);

                    //This code is for the University test
                    alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                            SystemClock.elapsedRealtime() +
                                    10 * 1000, pendingIntent);
                    //This code works for the app
//                alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
//                        calendar.getTimeInMillis(), pendingIntent);

                    Intent intent = new Intent(LiabilityInsuranceActivity.this, CarProfileActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LiabilityInsuranceActivity.this, "The start date must be lower than the end date.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void CreateNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "liability";
            String desc = "Channel for Alarm Manager";
            int imp = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("liability", name, imp);
            channel.setDescription(desc);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
