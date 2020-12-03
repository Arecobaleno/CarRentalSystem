package com.example.carrental;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DBManager extends SQLiteOpenHelper
{

    private static final String dbname = "VendingVehicleMachine.db";
    public DBManager( Context context) {
        super(context,dbname , null, 1);
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "create table tbl_registerUser(firstName text, " +
                "lastName text, username text primary key,password text,role text,email text,phone text,address text," +
                "city text,state text,zipCode text,utaId text,member integer)";
        db.execSQL(qry);
        qry = "insert into tbl_registerUser values('Zhengyu','Chen','czy','123456','Admin','12314@qq.com','13242424112','bupt','beijing','haidian','131312','1001889069',1)";
        db.execSQL(qry);
        qry = "insert into tbl_registerUser values('Peihang','Liu','lph','123456','User','12314@qq.com','13242424112','bupt','beijing','haidian','131312','1001889085',1)";
        db.execSQL(qry);
        qry = "insert into tbl_registerUser values('Jiaxi','Liu','ljx','123456','User','12314@qq.com','13242424112','bupt','beijing','haidian','131312','1001889070',1)";
        db.execSQL(qry);
        qry = "insert into tbl_registerUser values('Jiayi','Zhang','zjy','123456','User','12314@qq.com','13242424112','bupt','beijing','haidian','131312','1001889097',1)";
        db.execSQL(qry);
        qry = "insert into tbl_registerUser values('Yu','Feng','fy','123456','Manager','12314@qq.com','13242424112','bupt','beijing','haidian','131312','1001889071',1)";
        db.execSQL(qry);
        qry = "insert into tbl_registerUser values('Ruidong','Li','lrd','123456','Manager','12314@qq.com','13242424112','bupt','beijing','haidian','131312','1001889090',1)";
        db.execSQL(qry);
        qry = "create table car_information (carName text primary key, capacity integer," +
                " weekdayRate real, weekendRate real, weekRate real, GPS real, OnStar real, SiriusXM real)";
        db.execSQL(qry);
        qry = "insert into car_information values('Smart',1,32.99,37.99,230.93,3.00,5.00,7.00)";
        db.execSQL(qry);
        qry = "insert into car_information values('Economy',3,39.99,44.99,279.93,3.00,5.00,7.00)";
        db.execSQL(qry);
        qry = "insert into car_information values('Compact',4,44.99,49.99,314.93,3.00,5.00,7.00)";
        db.execSQL(qry);
        qry = "insert into car_information values('Intermediate',4,45.99,50.99,321.93,3.00,5.00,7.00)";
        db.execSQL(qry);
        qry = "insert into car_information values('Standard',5,48.99,53.99,342.93,3.00,5.00,7.00)";
        db.execSQL(qry);
        qry = "insert into car_information values('Full Size',6,52.99,57.99,370.93,3.00,5.00,7.00)";
        db.execSQL(qry);
        qry = "insert into car_information values('SUV',8,59.99,64.99,419.93,3.00,5.00,7.00)";
        db.execSQL(qry);
        qry = "insert into car_information values('MiniVan',9,59.99,64.99,419.93,3.00,5.00,7.00)";
        db.execSQL(qry);
        qry = "insert into car_information values('Ultra Sports',2,199.99,204.99,1399.93,5.00,7.00,9.00)";
        db.execSQL(qry);
        qry = "create table reservation (orderId text primary key, orderCreateTime text," +
                " reservationStatus text, startDate real, startTime text, carName text, capacity integer," +
                "duration real, rateType text, extraService text, fee real)";
        db.execSQL(qry);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_registerUser");
        onCreate(db);
    }

    public String addRecord(String p1, String p2, String p3,String p4,String p5,String p6,
                            String p7,String p8,String p9, String p10, String p11,String p12, String p13)

    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("data",p1);
        // put remainder of data stored here

        long res = db.insert("tbl_registerUser", null,cv );
        if(res== -1)
            return "failed";
        else
            return "Account Created Successfully";

    }
}
