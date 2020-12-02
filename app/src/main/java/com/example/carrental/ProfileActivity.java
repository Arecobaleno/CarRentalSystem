package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");
        Intent intent = getIntent();
        String user = intent.getStringExtra("username");
        SQLiteDatabase sqldb = this.openOrCreateDatabase("VendingVehicleMachine.db", MODE_PRIVATE, null);
        Cursor cursor = sqldb.rawQuery("select name FROM sqlite_master WHERE type='table' AND name='tbl_registerUser'", null);
        String query = "Select * from tbl_registerUser where username = '" + user + "'";
        cursor = sqldb.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            String firstname = cursor.getString(cursor.getColumnIndex("firstname"));
            String lastname = cursor.getString(cursor.getColumnIndex("lastname"));
            String username = cursor.getString(cursor.getColumnIndex("username"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String usertype = cursor.getString(cursor.getColumnIndex("usertype"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            String city = cursor.getString(cursor.getColumnIndex("city"));
            String state = cursor.getString(cursor.getColumnIndex("state"));
            String zipcode = cursor.getString(cursor.getColumnIndex("zipcode"));
            String member = cursor.getString(cursor.getColumnIndex("menber"));

            EditText text = findViewById(R.id.textInputEditText2);
            text.setText("1001889085");
            text = findViewById(R.id.editText12);
            text.setText(username);
            text = findViewById(R.id.editText13);
            text.setText(password);
            text = findViewById(R.id.editText14);
            text.setText(lastname);
            text = findViewById(R.id.editText15);
            text.setText(firstname);
            text = findViewById(R.id.editText16);
            text.setText(phone);
            text = findViewById(R.id.editText17);
            text.setText(email);
            text = findViewById(R.id.editText18);
            text.setText(address);
            text = findViewById(R.id.editText19);
            text.setText(city);
            text = findViewById(R.id.editText20);
            text.setText(state);
            text = findViewById(R.id.editText21);
            text.setText(zipcode);
        }
        cursor.close();
    }

    public void update(View view) {
        Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
    }

    public void revoke(View view) {
        Toast.makeText(getApplicationContext(), "Revoked Successfully", Toast.LENGTH_SHORT).show();
    }
}