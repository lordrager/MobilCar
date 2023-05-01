package com.example.mobilcar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class TechReviewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tech_review);

        TextView name = (TextView) findViewById(R.id.name);
        TextView startDate = (TextView) findViewById(R.id.editStartDate);
        TextView endDate = (TextView) findViewById(R.id.editEndDate);
        TextView price = (TextView) findViewById(R.id.editPrice);

        Button confirmDoc = (Button) findViewById(R.id.confirmDocbtn);

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
                Intent intent = new Intent(TechReviewActivity.this, LiabilityInsuranceActivity.class);
                startActivity(intent);
            }
        });

    }
}
