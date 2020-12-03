package com.example.carrental;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ReservationDetail extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservationdetail);
        Intent intent = getIntent();
        String orderId = intent.getStringExtra("orderId");
        String orderCreateTime, reservationStatus, startTime, username, utaId, phone, email, carName,
                rateType, extraService;
        Double startDate, duration, fee;
        int capacity;
        dbHelper = new MyDatabaseHelper(this, "rental.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("reservation",null,"orderId=\""+orderId+"\"",null,
                null,null,null);
        if(cursor.moveToFirst()) {
            orderCreateTime = cursor.getString(cursor.getColumnIndex("orderCreateTime"));
            reservationStatus = cursor.getString(cursor.getColumnIndex("reservationStatus"));
            startTime = cursor.getString(cursor.getColumnIndex("startTime"));
            username = cursor.getString(cursor.getColumnIndex("username"));
            utaId = cursor.getString(cursor.getColumnIndex("utaId"));
            phone = cursor.getString(cursor.getColumnIndex("phone"));
            email = cursor.getString(cursor.getColumnIndex("email"));
            carName = cursor.getString(cursor.getColumnIndex("carName"));
            rateType = cursor.getString(cursor.getColumnIndex("rateType"));
            extraService = cursor.getString(cursor.getColumnIndex("extraService"));
            startDate = cursor.getDouble(cursor.getColumnIndex("startDate"));
            duration = cursor.getDouble(cursor.getColumnIndex("duration"));
            fee = cursor.getDouble(cursor.getColumnIndex("fee"));
            capacity = cursor.getInt(cursor.getColumnIndex("capacity"));
        }
        cursor.close();

    }

}
