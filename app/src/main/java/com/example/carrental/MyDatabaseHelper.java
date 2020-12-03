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

    public static final String CREATE_CAR_INFO = "create table car_info ("
            + "carName text primary key, "
            + "capacity integer, "
            + "weekdayRate real, "
            + "weekendRate real, "
            + "weekRate real, "
            + "GPS real, "
            + "OnStar real, "
            + "SiriusXM real)";

    public static final String CREATE_RESERVATION = "create table reservation ("
            + "orderId text primary key, "
            + "orderCreateTime text, "
            + "reservationStatus text, "
            + "startDate real, "
            + "startTime text, "
            + "username text, "
            + "utaId text, "
            + "phone text, "
            + "email text, "
            + "carName text, "
            + "capacity integer, "
            + "duration real, "
            + "rateType text, "
            + "extraService text, "
            + "fee real)";

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
        db.execSQL(CREATE_CAR_INFO);
        qry = "insert into car_info values('Smart',1,32.99,37.99,230.93,3.00,5.00,7.00)";
        db.execSQL(qry);
        qry = "insert into car_info values('Economy',3,39.99,44.99,279.93,3.00,5.00,7.00)";
        db.execSQL(qry);
        qry = "insert into car_info values('Compact',4,44.99,49.99,314.93,3.00,5.00,7.00)";
        db.execSQL(qry);
        qry = "insert into car_info values('Intermediate',4,45.99,50.99,321.93,3.00,5.00,7.00)";
        db.execSQL(qry);
        qry = "insert into car_info values('Standard',5,48.99,53.99,342.93,3.00,5.00,7.00)";
        db.execSQL(qry);
        qry = "insert into car_info values('Full Size',6,52.99,57.99,370.93,3.00,5.00,7.00)";
        db.execSQL(qry);
        qry = "insert into car_info values('SUV',8,59.99,64.99,419.93,3.00,5.00,7.00)";
        db.execSQL(qry);
        qry = "insert into car_info values('MiniVan',9,59.99,64.99,419.93,3.00,5.00,7.00)";
        db.execSQL(qry);
        qry = "insert into car_info values('Ultra Sports',2,199.99,204.99,1399.93,5.00,7.00,9.00)";
        db.execSQL(qry);
        db.execSQL(CREATE_RESERVATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
