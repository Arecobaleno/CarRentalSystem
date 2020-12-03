package com.example.carrental.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.carrental.MainActivity;
import com.example.carrental.ProfileActivity;
import com.example.carrental.R;
import com.example.carrental.cars.Car_list;

public class User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        setTitle("User Home Screen");
    }

    public void logout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void view_profile(View view) {
        Intent last_intent = getIntent();
        String username = last_intent.getStringExtra("username");
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("admin", false);
        startActivity(intent);
    }

    public void view_cars(View view) {
        Intent intent = new Intent(this, Car_list.class);
        startActivity(intent);
    }
}