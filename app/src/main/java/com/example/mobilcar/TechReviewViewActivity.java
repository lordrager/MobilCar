package com.example.mobilcar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilcar.Database.FirebaseDatabase.FireBaseTechService;
import com.example.mobilcar.Models.Classes.TechReview;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class TechReviewViewActivity extends AppCompatActivity {
    String modelString;
    String techname;
    @Override
    protected void onStart()
    {
        super.onStart();
        Intent getModel = getIntent();
        modelString = getModel.getStringExtra("Car_Model");
        techname = getModel.getStringExtra("Tech");

        EditText name = (EditText) findViewById(R.id.nameTech);
        EditText startdate = (EditText) findViewById(R.id.startdateText);
        EditText enddate = (EditText) findViewById(R.id.endDateText);
        EditText price = (EditText) findViewById(R.id.priceText);


        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        DocumentReference docRef =  db.collection("owners").document(Objects.requireNonNull(fAuth.getUid())).collection("cars").document(modelString).collection("tech").document(techname);

        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                TechReview techReview = documentSnapshot.toObject(TechReview.class);
                name.setText(techReview.getName());
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_review_view);

        Button savebtn = (Button) findViewById(R.id.save);
        Button deletebtn = (Button) findViewById(R.id.delete);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.nameTech);
                EditText startdate = (EditText) findViewById(R.id.startdateText);
                EditText enddate = (EditText) findViewById(R.id.endDateText);
                EditText price = (EditText) findViewById(R.id.priceText);

                String newname = name.getText().toString().trim();
                String newstartdate = startdate.getText().toString().trim();
                String newenddate = enddate.getText().toString().trim();
                String newprice = price.getText().toString().trim();

                Date start;
                Date end;
                try {
                    start=new SimpleDateFormat("dd/MM/yyyy").parse(newstartdate);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                try {
                    end = new SimpleDateFormat("dd/MM/yyyy").parse(newenddate);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                FireBaseTechService fireBaseTechService = new FireBaseTechService();
                TechReview techReview = new TechReview(newname, start, end, newprice);
                fireBaseTechService.updateTech(techReview, modelString);
                Intent intent = new Intent(TechReviewViewActivity.this, CarProfileActivity.class);
                startActivity(intent);
            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getModel = getIntent();
                String modelString;
                modelString = getModel.getStringExtra("Car_Model");
                FireBaseTechService fireBaseTechService = new FireBaseTechService();
                fireBaseTechService.deleteTech(modelString);
                Intent intent = new Intent(TechReviewViewActivity.this, CarProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}