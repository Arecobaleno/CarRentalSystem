package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carrental.admin.Admin;
import com.example.carrental.manager.Manager;
import com.example.carrental.user.User;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dbHelper = new MyDatabaseHelper(this, "rental.db", null, 1);
//        DBManager dbmanager = new DBManager(this, "VendingVehicleMachine.db", null, 1);
//        dbmanager.getWritableDatabase();
    }

    public void login(View view) {
        EditText username = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextTextPersonName2);

        String data = checkUser(username, password);
        Intent intent;
        switch (data) {
            case "Error":
                Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                break;
            case "Manager":
                intent = new Intent(this, Manager.class);
                intent.putExtra("username", username.getText().toString().trim());
                startActivity(intent);
                break;
            case "Admin":
                intent = new Intent(this, Admin.class);
                intent.putExtra("username", username.getText().toString().trim());
                startActivity(intent);
                break;
            default:
                intent = new Intent(this, User.class);
                intent.putExtra("username", username.getText().toString().trim());
                startActivity(intent);
                break;
        }
        username.setText("");
        password.setText("");
    }

    public void register(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public String checkUser(EditText username, EditText password) {
        String user = username.getText().toString().trim();
        String pwd = password.getText().toString().trim();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("user_info", new String[]{"role"}, "username=\""+user+"\" and password=\""+pwd+"\"", null, null, null, null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return "Error";
        } else {
            String data = "User";
            if (cursor.moveToFirst()) {
                data = cursor.getString(cursor.getColumnIndex("role"));
            }
            cursor.close();
            return data;
        }
//        SQLiteDatabase sqldb = this.openOrCreateDatabase("VendingVehicleMachine.db", MODE_PRIVATE, null);
//        Cursor cursor = sqldb.rawQuery("select name FROM sqlite_master WHERE type='table' AND name='tbl_registerUser'", null);
//        if (cursor.getCount() > 0) {
//            String query = "Select * from tbl_registerUser where username = '" + user + "' and password = '" + pwd + "'";
//            cursor = sqldb.rawQuery(query, null);
//            if (cursor.getCount() <= 0) {
//                cursor.close();
//                return "Error";
//            } else {
//                String data = "User";
//                if (cursor.moveToFirst()) {
//                    data = cursor.getString(cursor.getColumnIndex("usertype"));
//                }
//                cursor.close();
//                return data;
//            }
//        } else {
//            cursor.close();
//            return "Error";
//        }
    }
}