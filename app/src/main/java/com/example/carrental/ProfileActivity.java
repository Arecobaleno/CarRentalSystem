package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    String firstname, lastname, username, password, usertype, email, phone, address, city, state, zipcode, utaid, member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");
        Intent intent = getIntent();
        String user = intent.getStringExtra("username");
        boolean admin_edit = intent.getBooleanExtra("admin", false);
        dbHelper = new MyDatabaseHelper(this, "rental.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("user_info", null, "username=\""+user+"\"", null, null, null, null);
//        db.rawQuery("select name FROM sqlite_master WHERE type='table' AND name='user_info'", null);
//        Cursor cursor = db.rawQuery("select * from user_info", null);
        if (cursor.moveToFirst()) {
            firstname = cursor.getString(cursor.getColumnIndex("firstName"));
            lastname = cursor.getString(cursor.getColumnIndex("lastName"));
            username = cursor.getString(cursor.getColumnIndex("username"));
            password = cursor.getString(cursor.getColumnIndex("password"));
            usertype = cursor.getString(cursor.getColumnIndex("role"));
            email = cursor.getString(cursor.getColumnIndex("email"));
            phone = cursor.getString(cursor.getColumnIndex("phone"));
            address = cursor.getString(cursor.getColumnIndex("address"));
            city = cursor.getString(cursor.getColumnIndex("city"));
            state = cursor.getString(cursor.getColumnIndex("state"));
            zipcode = cursor.getString(cursor.getColumnIndex("zipcode"));
            utaid = cursor.getString(cursor.getColumnIndex("utaid"));
            member = cursor.getString(cursor.getColumnIndex("member"));
        }
        cursor.close();
        EditText username_widget = findViewById(R.id.profile_user);
        username_widget.setText(username);
        EditText uta_id_widget = findViewById(R.id.profile_uta_id);
        uta_id_widget.setText(utaid);
        EditText password_widget = findViewById(R.id.profile_password);
        password_widget.setText(password);
        EditText last_name_widget = findViewById(R.id.profile_last_name);
        last_name_widget.setText(lastname);
        EditText first_name_widget = findViewById(R.id.profile_first_name);
        first_name_widget.setText(firstname);
        EditText phone_widget = findViewById(R.id.profile_phone);
        phone_widget.setText(phone);
        EditText email_widget = findViewById(R.id.profile_email);
        email_widget.setText(email);
        EditText street_address_widget = findViewById(R.id.profile_street);
        street_address_widget.setText(address);
        EditText city_widget = findViewById(R.id.profile_city);
        city_widget.setText(city);
        EditText state_widget = findViewById(R.id.profile_state);
        state_widget.setText(state);
        EditText zip_code_widget = findViewById(R.id.profile_zip_code);
        zip_code_widget.setText(zipcode);
        Button update_widget = findViewById(R.id.profile_update);
        RadioGroup role_widget = findViewById(R.id.profile_role);
        RadioGroup member_widget = findViewById(R.id.profile_member);

        if (usertype.equals("Admin")) {
            username_widget.setFocusable(false);
            uta_id_widget.setFocusable(false);
            password_widget.setFocusable(false);
            last_name_widget.setFocusable(false);
            first_name_widget.setFocusable(false);
            phone_widget.setFocusable(false);
            email_widget.setFocusable(false);
            street_address_widget.setFocusable(false);
            city_widget.setFocusable(false);
            state_widget.setFocusable(false);
            zip_code_widget.setFocusable(false);
            update_widget.setVisibility(View.GONE);
            role_widget.check(R.id.profile_role_admin);
            findViewById(R.id.profile_role_manager).setEnabled(false);
            findViewById(R.id.profile_role_user).setEnabled(false);
        } else if (usertype.equals("User")) {
            member_widget.setVisibility(View.VISIBLE);
            role_widget.check(R.id.profile_role_user);
            if (!admin_edit) {
                findViewById(R.id.profile_role_admin).setEnabled(false);
                findViewById(R.id.profile_role_manager).setEnabled(false);
            }
            if (member.equals("0")) {
                member_widget.check(R.id.profile_member_false);
                if (!admin_edit) {
                    findViewById(R.id.profile_member_true).setEnabled(false);
                }
            } else {
                member_widget.check(R.id.profile_member_true);
                if (!admin_edit) {
                    findViewById(R.id.profile_member_false).setEnabled(false);
                }
            }
            if (admin_edit) {
                findViewById(R.id.profile_revoke).setVisibility(View.VISIBLE);
            }
        } else {
            role_widget.check(R.id.profile_role_manager);
            findViewById(R.id.profile_role_admin).setEnabled(false);
            findViewById(R.id.profile_role_user).setEnabled(false);
        }
    }

    public void update(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String qry = "delete from user_info where username='" + username + "'";
        db.execSQL(qry);
        qry = "insert into user_info values('"+firstname+"','"+lastname+"','"+username+"','"+password+"','"+usertype+"','"+email+"','"+phone+"','"+address+"','"+city+"','"+state+"','"+zipcode+"','"+utaid+"',"+ Integer.valueOf(member) +")";
        db.execSQL(qry);
        Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
    }
// TODO
    public void revoke(View view) {
        Toast.makeText(getApplicationContext(), "Revoked Successfully", Toast.LENGTH_SHORT).show();
    }

    public void logout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}