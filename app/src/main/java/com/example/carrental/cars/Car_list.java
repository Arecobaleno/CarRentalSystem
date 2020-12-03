package com.example.carrental.cars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.carrental.MainActivity;
import com.example.carrental.MyDatabaseHelper;
import com.example.carrental.ProfileActivity;
import com.example.carrental.R;
import com.example.carrental.admin.UserAdapter;
import com.example.carrental.admin.Userlist;
import com.example.carrental.admin.user_item;

import java.util.ArrayList;
import java.util.List;

public class Car_list extends AppCompatActivity {

    private final List<Car_item> car_items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);
        initCarlist();
        //TODO
        final Intent intent = new Intent(this, Car_detail.class);
        CarAdapter adapter = new CarAdapter(Car_list.this, R.layout.car_item, car_items);
        ListView listView = findViewById(R.id.cars_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Car_item item = car_items.get(position);
                intent.putExtra("car_name", item.get_car_name());
                intent.putExtra("role", "user");
                startActivity(intent);
            }
        });
    }

    private void initCarlist() {
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, "rental.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("car_info", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String car_name = cursor.getString(cursor.getColumnIndex("carName"));
                String capacity = cursor.getString(cursor.getColumnIndex("capacity"));
                String car_status = cursor.getString(cursor.getColumnIndex("status"));
                Car_item car = new Car_item(car_name, capacity, car_status);
                car_items.add(car);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }

    public void logout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}