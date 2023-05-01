package com.example.mobilcar;

import android.content.Context;
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
    public CarListAdapter(@NonNull Context context, ArrayList<Car> dataModalArrayList) {
        super(context, 0, dataModalArrayList);
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
                // on the item click on our list view.
                // we are displaying a toast message.
                Toast.makeText(getContext(), "Item clicked is : " + dataModal.getModel(), Toast.LENGTH_SHORT).show();
            }
        });
        return listItemView;
    }

}
