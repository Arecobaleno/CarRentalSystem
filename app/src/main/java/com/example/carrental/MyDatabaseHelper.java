package com.example.carrental;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_USER_INFO = "create table user_info ("
            + "firstName text, "
            + "lastName text, "
            + "username text primary key, "
            + "password text, "
            + "role text, "
            + "email text, "
            + "phone text, "
            + "address text, "
            + "city text, "
            + "state text, "
            + "zipcode text, "
            + "utaid text, "
            + "member integer)";

    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry;
        db.execSQL(CREATE_USER_INFO);
        qry = "insert into user_info values('Zhengyu','Chen','czy','123456','Admin','12314@qq.com','13242424112','bupt','beijing','haidian','131312','1001889069',1)";
        db.execSQL(qry);
        qry = "insert into user_info values('Peihang','Liu','lph','123456','User','12314@qq.com','13242424112','bupt','beijing','haidian','131312','1001889085',1)";
        db.execSQL(qry);
        qry = "insert into user_info values('Jiaxi','Liu','ljx','123456','User','12314@qq.com','13242424112','bupt','beijing','haidian','131312','1001889070',1)";
        db.execSQL(qry);
        qry = "insert into user_info values('Jiayi','Zhang','zjy','123456','User','12314@qq.com','13242424112','bupt','beijing','haidian','131312','1001889097',1)";
        db.execSQL(qry);
        qry = "insert into user_info values('Yu','Feng','fy','123456','Manager','12314@qq.com','13242424112','bupt','beijing','haidian','131312','1001889071',1)";
        db.execSQL(qry);
        qry = "insert into user_info values('Ruidong','Li','lrd','123456','Manager','12314@qq.com','13242424112','bupt','beijing','haidian','131312','1001889090',1)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
