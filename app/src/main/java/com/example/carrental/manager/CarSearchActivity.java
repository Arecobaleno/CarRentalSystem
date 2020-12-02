package com.example.carrental.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.carrental.R;

public class CarSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_search);
        setTitle("Search for Cars");
    }
}