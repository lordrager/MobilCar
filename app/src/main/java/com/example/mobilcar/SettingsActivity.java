package com.example.mobilcar;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.mobilcar.Database.FirebaseDatabase.FireBaseCarService;
import com.example.mobilcar.Database.FirebaseDatabase.FireBaseOwnerService;
import com.example.mobilcar.Models.Classes.Owner;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Locale;
import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "channel_id01";
    private static final int NOTIFICATION_ID = 1;

    @Override
    protected void onStart() {
        super.onStart();
        TextView name = (TextView) findViewById(R.id.nameLog);
        TextView username = (TextView) findViewById(R.id.usernameLog);
        TextView email = (TextView) findViewById(R.id.emailLog);
        TextView password = (TextView) findViewById(R.id.passwordLog);

        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("owners").document(Objects.requireNonNull(fAuth.getUid()));
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Owner owner = documentSnapshot.toObject(Owner.class);
                name.setText(owner.getName());
                email.setText(owner.getEmail());
                username.setText(owner.getUsername());
                password.setText(owner.getPassword());
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_settings);

        MaterialButton logoutbtn = (MaterialButton) findViewById(R.id.logout);
        MaterialButton deletebtn = (MaterialButton) findViewById(R.id.delete);
        MaterialButton changeLang = (MaterialButton) findViewById(R.id.changeLang);
        MaterialButton savebtn = (MaterialButton) findViewById(R.id.save);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.sweethome) {
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

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth fAuth;
                fAuth = FirebaseAuth.getInstance();
                fAuth.signOut();
                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                startActivity(intent);

                showNotification();
            }
        });

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth fAuth;
                fAuth = FirebaseAuth.getInstance();
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                TextView name = (TextView) findViewById(R.id.nameLog);
                TextView username = (TextView) findViewById(R.id.usernameLog);
                TextView email = (TextView) findViewById(R.id.emailLog);
                TextView password = (TextView) findViewById(R.id.passwordLog);
                DocumentReference docRef = db.collection("owners").document(Objects.requireNonNull(fAuth.getUid()));
                docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        Owner owner = documentSnapshot.toObject(Owner.class);
                        String newname = name.getText().toString().trim();
                        String newusername = username.getText().toString().trim();
                        String newemail = email.getText().toString().trim();
                        String newpassword = password.getText().toString().trim();
                        owner.setName(newname);
                        owner.setUsername(newusername);
                        owner.setEmail(newemail);
                        owner.setPassword(newpassword);
                        FireBaseOwnerService fireBaseOwnerService = new FireBaseOwnerService();
                        fireBaseOwnerService.updateOwner(owner);
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        user.updatePassword(newpassword).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "User password updated.");
                                }
                            }
                        });
                        user.updateEmail(newemail).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "User email updated.");
                                }
                            }
                        });

                        Intent intent = new Intent(SettingsActivity.this, PersonInfoMainPage.class);
                        startActivity(intent);
                    }
                });
            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FireBaseOwnerService fireBaseOwnerService = new FireBaseOwnerService();
                fireBaseOwnerService.deleteOwner();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                FireBaseCarService fireBaseCarService = new FireBaseCarService();
                fireBaseCarService.deleteCar();

                user.delete()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "User account deleted.");
                                    showNotification();
                                    Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                }
                            }
                        });
            }
        });

        changeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLangDialog();
            }
        });
    }

    private void showNotification() {

        createNotificationChannel();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.baseline_directions_car_24);
        builder.setContentTitle("GOODBYE!");
        builder.setContentText("Come back to MobilCar soon!");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "My Notification";
            String description = "My notification description";

            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void showChangeLangDialog() {
        final String[] listItems = {"English", "Български"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(SettingsActivity.this);
        mBuilder.setTitle("Choose Language");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    setLocale("en");
                    recreate();
                }
                if (which == 1) {
                    setLocale("bg");
                    recreate();
                }
                dialog.dismiss();
            }
        });
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My Lang", lang);
        editor.apply();
    }

    public void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My Lang", "");
        setLocale(language);
    }
}