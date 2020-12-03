package com.example.carrental;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carrental.javaBean.reservation_item;

import java.util.ArrayList;
import java.util.List;

public class ReservationList extends AppCompatActivity {

    private List<reservation_item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservationlist);
        initReservationList();
        final Intent intent = new Intent(this, ReservationDetail.class);
        ArrayAdapter<reservation_item> adapter = new ArrayAdapter<reservation_item>(ReservationList.this,
                android.R.layout.simple_list_item_1, items);
        ListView listView = findViewById(R.id.reservationlist_listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                reservation_item item = items.get(position);
                intent.putExtra("orderId",item.getOrderId());
                startActivity(intent);
            }
        });
    }

    private void initReservationList() {
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, "rental.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("reservation",null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do {
                String orderId = cursor.getString(cursor.getColumnIndex("orderId"));
                String orderCreateTime = cursor.getString(cursor.getColumnIndex("orderCreateTime"));
                Double startDate = cursor.getDouble(cursor.getColumnIndex("startDate"));
                Double fee = cursor.getDouble(cursor.getColumnIndex("fee"));
                String reservationStatus = cursor.getString(cursor.getColumnIndex("reservationStatus"));
                reservation_item item = new reservation_item(orderId, orderCreateTime,reservationStatus, startDate,fee);
                items.add(item);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}
