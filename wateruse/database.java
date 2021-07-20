package com.example.user.wateruse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by gmlron001 on 2018/08/13.
 */

public class database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "inluts.db";
    public static final String TABLE_NAME = "dy";
    public static final String COL_1 = "date";
    public static final String COL_2 = "bath";
    public static final String COL_3 = "laundry";
    public static final String COL_4 = "clean";
    public static final String COL_5 = "dish";
    public static final String COL_6 = "toilet";
    public static final String COL_7 = "drink";
    public static final String COL_8 = "hygn";
    public static final String COL_9 = "cook";
    public static final String COL_10 = "total";


    public database(Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (date TEXT,bath INTEGER,laundry INTEGER,clean INTEGER,dish INTEGER,toilet INTEGER,drink INTEGER,hygn INTEGER,cook INTEGER,total INTEGER)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String date,int bath,int laundry,int clean,int dish,int toilet, int drink,int hygn,int cook ,int total) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,date);
        contentValues.put(COL_2,bath);
        contentValues.put(COL_3,laundry);
        contentValues.put(COL_4,clean);
        contentValues.put(COL_5,dish);
        contentValues.put(COL_6,toilet);
        contentValues.put(COL_7,drink);
        contentValues.put(COL_8,hygn);
        contentValues.put(COL_9,cook);
        contentValues.put(COL_10,total);

        long result = db.insert(TABLE_NAME,null ,contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public Cursor getData(String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        String q="select * from "+TABLE_NAME+" where date="+date+";";
        Cursor res = db.rawQuery(q,null);
        if(res != null)
        {

            res.moveToFirst();
        }

        return res;
    }


}
