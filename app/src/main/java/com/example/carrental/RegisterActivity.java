package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText username_widget;
    EditText uta_id_widget;
    EditText password_widget;
    EditText last_name_widget;
    EditText first_name_widget;
    EditText phone_widget;
    EditText email_widget;
    EditText street_address_widget;
    EditText city_widget;
    EditText state_widget;
    EditText zip_code_widget;
    String role;
    Boolean isMember = true;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        setTitle("Register");
        final RadioGroup role_widget = findViewById(R.id.register_role);
        final RadioGroup member_widget = findViewById(R.id.register_member);
        username_widget = findViewById(R.id.register_user);
        uta_id_widget = findViewById(R.id.register_uta_id);
        password_widget = findViewById(R.id.register_password);
        last_name_widget = findViewById(R.id.register_last_name);
        first_name_widget = findViewById(R.id.register_first_name);
        phone_widget = findViewById(R.id.register_phone);
        email_widget = findViewById(R.id.register_email);
        street_address_widget = findViewById(R.id.register_street);
        city_widget = findViewById(R.id.register_city);
        state_widget = findViewById(R.id.register_state);
        zip_code_widget = findViewById(R.id.register_zip_code);
        dbHelper = new MyDatabaseHelper(this, "rental.db", null, 1);

        role_widget.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.register_role_user) {
                    member_widget.setVisibility(View.VISIBLE);
                    member_widget.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            isMember = checkedId == R.id.register_member_true;
                        }
                    });
                    role = "User";
                } else if (checkedId == R.id.register_role_admin) {
                    member_widget.setVisibility(View.GONE);
                    role = "Admin";
                } else {
                    member_widget.setVisibility(View.GONE);
                    role = "Manager";
                }
            }
        });

        DBManager dbmanager = new DBManager(this );
        dbmanager.getWritableDatabase();
    }

    public void register(View view) {
        String uta_id = uta_id_widget.getText().toString().trim();
        String username = username_widget.getText().toString().trim();
        String password = password_widget.getText().toString().trim();
        String last_name = last_name_widget.getText().toString().trim();
        String first_name = first_name_widget.getText().toString().trim();
        String phone = phone_widget.getText().toString().trim();
        String email = email_widget.getText().toString().trim();
        String street_address = street_address_widget.getText().toString().trim();
        String city = city_widget.getText().toString().trim();
        String state = state_widget.getText().toString().trim();
        String zip_code = zip_code_widget.getText().toString().trim();

//        SQLiteDatabase db = this.openOrCreateDatabase("VendingVehicleMachine.db", MODE_PRIVATE, null);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("firstName", first_name);
        values.put("lastName", last_name);
        values.put("username", username);
        values.put("password", password);
        values.put("role", role);
        values.put("email", email);
        values.put("phone", phone);
        values.put("address", street_address);
        values.put("city", city);
        values.put("state", state);
        values.put("zipcode", zip_code);
        values.put("utaid", uta_id);
        values.put("member", isMember? 1: 0);
        db.insert("user_info", null, values);
        Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }
}