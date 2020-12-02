package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

//    EditText uta_id_widget = findViewById(R.id.textInputEditText);
//    EditText username_widget = findViewById(R.id.editText);
//    EditText password_widget = findViewById(R.id.editText2);
//    EditText last_name_widget = findViewById(R.id.editText3);
//    EditText first_name_widget = findViewById(R.id.editText4);
//    EditText phone_widget = findViewById(R.id.editText6);
//    EditText email_widget = findViewById(R.id.editText7);
//    EditText street_address_widget = findViewById(R.id.editText8);
//    EditText city_widget = findViewById(R.id.editText9);
//    EditText state_widget = findViewById(R.id.editText11);
//    EditText zip_code_widget = findViewById(R.id.editText10);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        setTitle("Register");
        final RadioGroup role_widget = findViewById(R.id.role);
        final RadioGroup member_widget = findViewById(R.id.member);

        role_widget.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.role_user) {
                    member_widget.setVisibility(View.VISIBLE);
                } else {
                    member_widget.setVisibility(View.GONE);
                }
            }
        });
    }

    public void register(View view) {
        Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }
}