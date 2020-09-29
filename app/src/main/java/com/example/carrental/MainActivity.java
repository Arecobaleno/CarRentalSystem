package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBManager dbmanager = new DBManager(this );
        dbmanager.getWritableDatabase();
    }

    public void login(View view) {
        Intent intent = new Intent(this, Admin.class);

        EditText username = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextTextPersonName2);

        String data = checkUser(username, password);
        switch (data) {
            case "Error":
                Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                break;
            case "Manager":
                startActivity(new Intent(this, Manager.class));
                break;
            case "Admin":
                startActivity(new Intent(this, Admin.class));
                break;
            default:
                startActivity(new Intent(this, User.class));
                break;
        }
        username.setText("");
        password.setText("");
    }

    public void register(View view) {

    }

    public String checkUser(EditText username, EditText password) {
        String user = username.getText().toString().trim();
        String pwd = password.getText().toString().trim();
        SQLiteDatabase sqldb = this.openOrCreateDatabase("VendingVehicleMachine.db", MODE_PRIVATE, null);
        Cursor cursor = sqldb.rawQuery("select name FROM sqlite_master WHERE type='table' AND name='tbl_registerUser'", null);
        if (cursor.getCount() > 0) {
            String query = "Select * from tbl_registerUser where username = '" + user + "' and password = '" + pwd + "'";
            cursor = sqldb.rawQuery(query, null);
            if (cursor.getCount() <= 0) {
//                Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
//                username.setText("");
//                password.setText("");
                cursor.close();
                return "Error";
            } else {
                String data = "User";
                if (cursor.moveToFirst()) {
                    data = cursor.getString(cursor.getColumnIndex("usertype"));
                }
                cursor.close();
//                SharedPreferences.Editor session = sharedPreferences.edit();
//                session.putString("username", user);
//                session.putString("userType", data);
//                session.apply();
                return data;
//                if (data.equals("Manager")) {
//                    startActivity(new Intent(this, ManagerHomeScreen.class));
//                } else if (data.equals("Operator")) {
//                    startActivity(new Intent(this, OperatorHomeScreen.class));
//                } else
//                    startActivity(new Intent(this, UserHomeScreen.class));
//                username.setText("");
//                password.setText("");
            }
        } else {
//            Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
//            username.setText("");
//            password.setText("");
            cursor.close();
            return "Error";
        }
    }

}