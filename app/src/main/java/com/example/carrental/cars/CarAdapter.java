package com.example.carrental.cars;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.carrental.R;
import com.example.carrental.admin.user_item;

import java.util.List;

public class CarAdapter extends ArrayAdapter<Car_item> {

    private final int resourceId;

    public CarAdapter(Context context, int textViewResourceId, List<Car_item> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Car_item item = getItem(position);
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView utaid = (TextView) view.findViewById(R.id.car_item_name);
        TextView username = (TextView) view.findViewById(R.id.car_item_capacity);
        TextView rental_status = (TextView) view.findViewById(R.id.car_item_car_status);
        utaid.setText(item.get_car_name());
        username.setText(item.get_capacity());
        rental_status.setText(item.get_car_status());
        return view;
    }
}
