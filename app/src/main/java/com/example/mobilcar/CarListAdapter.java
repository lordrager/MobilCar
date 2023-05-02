package com.example.mobilcar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mobilcar.Models.Classes.Car;

import java.util.ArrayList;

public class CarListAdapter extends ArrayAdapter<Car> {
    private Context c;
    public CarListAdapter(@NonNull Context context, ArrayList<Car> dataModalArrayList) {
        super(context, 0, dataModalArrayList);
        this.c = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.car_list_layout, parent, false);
        }
        Car dataModal = getItem(position);
        TextView nameTV = listItemView.findViewById(R.id.idTVtext);
        //ImageView courseIV = listItemView.findViewById(R.id.idIVimage);

        nameTV.setText(dataModal.getModel());
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, "Item clicked is : " + dataModal.getModel(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(c, CarInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Car_Model",dataModal.getModel());
                c.startActivity(intent);
            }
        });
        return listItemView;
    }


}
