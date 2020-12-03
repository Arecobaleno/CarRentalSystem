package com.example.carrental.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.carrental.MainActivity;
import com.example.carrental.MyDatabaseHelper;
import com.example.carrental.R;
import com.example.carrental.cars.Car_detail;

public class CarSearchActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_search);
        setTitle("Search for Cars");
        dbHelper = new MyDatabaseHelper(this, "rental.db", null, 1);
    }

    public void search(View view) {
        EditText name_w = findViewById(R.id.car_search_name);
        EditText date_w = findViewById(R.id.car_search_date);
        String name = name_w.getText().toString().trim();
        String date = date_w.getText().toString().trim();
        Intent intent = new Intent(this, Car_detail.class);
        intent.putExtra("car_name", name);
        intent.putExtra("role", "manager");
        startActivity(intent);
    }

    public void logout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}