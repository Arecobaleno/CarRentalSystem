package com.example.carrental.admin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.carrental.R;
import androidx.annotation.NonNull;

import java.util.List;
public class UserAdapter extends ArrayAdapter<user_item> {

    private final int resourceId;

    public UserAdapter(Context context, int textViewResourceId, List<user_item> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        user_item item = getItem(position);
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView utaid = (TextView) view.findViewById(R.id.user_item_utaid);
        TextView username = (TextView) view.findViewById(R.id.user_item_username);
        TextView rental_status = (TextView) view.findViewById(R.id.user_item_rental_status);
        utaid.setText(item.get_utaid());
        username.setText(item.get_username());
        rental_status.setText(item.get_rentalstatus());
        return view;
    }
}
