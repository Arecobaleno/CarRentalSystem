package com.example.carrental.cars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carrental.MainActivity;
import com.example.carrental.MyDatabaseHelper;
import com.example.carrental.R;
import com.example.carrental.user.User;

public class Car_detail extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    String car_name, capacity, weekdayRate, weekendRate, weekRate, GPS, OnStar, SiriusXM, car_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);
        setTitle("Car Detail");
        Intent intent = getIntent();
        car_name = intent.getStringExtra("car_name");
        String role = intent.getStringExtra("role");
        dbHelper = new MyDatabaseHelper(this, "rental.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("car_info", null, "carName=\""+car_name+"\"", null, null, null, null);
        if(cursor.moveToFirst()) {
            capacity = cursor.getString(cursor.getColumnIndex("capacity"));
            weekdayRate = cursor.getString(cursor.getColumnIndex("weekdayRate"));
            weekendRate = cursor.getString(cursor.getColumnIndex("weekendRate"));
            weekRate = cursor.getString(cursor.getColumnIndex("weekRate"));
            GPS = cursor.getString(cursor.getColumnIndex("GPS"));
            OnStar = cursor.getString(cursor.getColumnIndex("OnStar"));
            SiriusXM = cursor.getString(cursor.getColumnIndex("SiriusXM"));
            car_status = cursor.getString(cursor.getColumnIndex("status"));
        }
        cursor.close();
        EditText car_name_widget = findViewById(R.id.car_detail_carName);
        car_name_widget.setText(car_name);
        EditText capacity_widget = findViewById(R.id.car_detail_capacity);
        capacity_widget.setText(capacity);
        EditText weekdayRate_widget = findViewById(R.id.car_detail_weekdayRate);
        weekdayRate_widget.setText(weekdayRate);
        EditText weekendRate_widget = findViewById(R.id.car_detail_weekendRate);
        weekendRate_widget.setText(weekendRate);
        EditText weekRate_widget = findViewById(R.id.car_detail_weekRate);
        weekRate_widget.setText(weekRate);
        EditText GPS_widget = findViewById(R.id.car_detail_GPS);
        GPS_widget.setText(GPS);
        EditText OnStar_widget = findViewById(R.id.car_detail_OnStar);
        OnStar_widget.setText(OnStar);
        EditText SiriusXM_widget = findViewById(R.id.car_detail_SiriusXM);
        SiriusXM_widget.setText(SiriusXM);
        EditText car_status_widget = findViewById(R.id.car_detail_status);
        car_status_widget.setText(car_status);
        if (!car_status.equals("available") || role.equals("manager")) {
            Button button = findViewById(R.id.car_detail_reserve);
            button.setVisibility(View.GONE);
        }
    }
    //TODO
    public void reserve(View view) {
        String qry = "UPDATE car_info SET status='reserved' WHERE carName=\"" + car_name + "\"";
        dbHelper = new MyDatabaseHelper(this, "rental.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL(qry);
        Toast.makeText(getApplicationContext(), "Reserved Successfully", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, User.class);
        startActivity(intent);
    }

    public void logout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
