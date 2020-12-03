package com.example.carrental.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.carrental.MyDatabaseHelper;
import com.example.carrental.ProfileActivity;
import com.example.carrental.R;
import com.example.carrental.user.User;

import java.util.ArrayList;
import java.util.List;

public class Userlist extends AppCompatActivity {

    private List<user_item> user_items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        initUserlist();
        final Intent intent = new Intent(this, ProfileActivity.class);
        UserAdapter adapter = new UserAdapter(Userlist.this, R.layout.user_item, user_items);
        ListView listView = findViewById(R.id.userlist_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                user_item item = user_items.get(position);
                intent.putExtra("username", item.get_username());
                intent.putExtra("admin", true);
                startActivity(intent);
            }
        });
    }

    private void initUserlist() {
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, "rental.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("user_info", null, "role=\"User\"", null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String utaid = cursor.getString(cursor.getColumnIndex("utaid"));
                String username = cursor.getString(cursor.getColumnIndex("username"));
                String rentalStatus = "free"; //TODO
                user_item user = new user_item(utaid, username, rentalStatus);
                user_items.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}