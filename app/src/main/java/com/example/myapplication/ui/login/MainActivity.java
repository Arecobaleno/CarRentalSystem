package com.example.myapplication.ui.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    /*TODO Need to make fields Mandatory*/
    private DBManager dbmanager;
    TextView textView;
    EditText username, password;
    SharedPreferences sharedpreferences;
    EditText edtPassword;
    public static final String MyPREFERENCES = "MyPrefs" ;
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        dbmanager = new DBManager(this );
        dbmanager.getWritableDatabase();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidUser(username, password);
            }
        });
//        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
//        textView = findViewById(R.id.textViewLink);
//        textView.setMovementMethod(LinkMovementMethod.getInstance());
//        @SuppressLint("WrongViewCast") AppCompatCheckBox checkbox = (AppCompatCheckBox) findViewById(R.id.checkBox);
//        edtPassword = findViewById(R.id.pwdText);
//            checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                    if (isChecked) {
//                        edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                    } else {
//                        edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                    }
//                }
//            });
    }
    public void checkValidUser(EditText username, EditText password) {

        if (username.getText().toString().trim().length() != 0 && password.getText().toString().trim().length() != 0) {
            SQLiteDatabase sqldb = this.openOrCreateDatabase("VendingVehicleMachine.db", MODE_PRIVATE, null);
            Cursor cursor = sqldb.rawQuery("select name FROM sqlite_master WHERE type='table' AND name='tbl_registerUser'", null);
            if (cursor.getCount() > 0) {
                String query = "Select * from tbl_registerUser where username = '" + username.getText().toString().trim() + "' and password = '" + password.getText().toString().trim() + "'";
                cursor = sqldb.rawQuery(query, null);
                if (cursor.getCount() <= 0) {
                    Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    username.setText("");
                    password.setText("");
                    cursor.close();
                } else {
                    String data = "User";
                    if (cursor.moveToFirst()) {
                        data = cursor.getString(cursor.getColumnIndex("usertype"));
                    }
                    cursor.close();
                    SharedPreferences.Editor session = sharedpreferences.edit();
                    session.putString("username", username.getText().toString().trim());
                    session.putString("userType", data);
                    session.commit();
                    if (data.equals("Manager")) {
                        startActivity(new Intent(this, ManagerHomeScreen.class));
                    } else if (data.equals("Operator")) {
                        startActivity(new Intent(this, OperatorHomeScreen.class));
                    } else
                        startActivity(new Intent(this, UserHomeScreen.class));
                    username.setText("");
                    password.setText("");
                }
            } else {
                Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                username.setText("");
                password.setText("");
                cursor.close();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Enter required fields", Toast.LENGTH_SHORT).show();
            username.setText("");
            password.setText("");
        }
    }
//    public void registerDetails(View view) {
//        startActivity(new Intent(this, Register.class));
//    }
//    public void forgotPassword(View view) {
//        startActivity(new Intent(this, ForgotPasswordScreen.class));
//    }
}
