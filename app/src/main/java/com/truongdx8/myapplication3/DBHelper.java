package com.truongdx8.myapplication3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "Student.db";
    public static int DB_VERSION = 1;

    public static String TABLE_USER = "USER";
    public static String user_id = "id";
    public static String user_name = "name";
    public static String user_age = "age";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String sql = "CREATE TABLE USER ( id INTEGER PRIMARY KEY autoincrement, name TEXT, age INTEGER)";
        String sql = "CREATE TABLE "+TABLE_USER+" ( "+user_id+
                " INTEGER PRIMARY KEY autoincrement, "+user_name+
                " TEXT, "+user_age+
                " INTEGER)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String insertData(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(user_name, user.getName());
        cv.put(user_age, user.getAge());
        long isSuccess = db.insert(TABLE_USER,null,cv);
        if(isSuccess>0)
        {
            return "Insert success";
        }
        else
        {
            return "Failed";
        }

    }

    public String updateData(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(user_name, "Tran Van Nam");
        int isSuccess = db.update(TABLE_USER,cv,user_id+" = "+user.getId(),null);
        if(isSuccess>0)
        {
            return "Success";
        }
        else
        {
            return "Failed";
        }
    }

    public String deleteData(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        int isSuccess = db.delete(TABLE_USER,user_id+" = "+id,null);

        if(isSuccess>0)
        {
            return "Success";
        }
        else
        {
            return "Failed";
        }
    }

    public List<User> getData()
    {
        List<User> userList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM USER";

        Cursor c = db.rawQuery(sql,null);

        if(c.getCount()>0)
        {
            c.moveToFirst();

            do {
                String name = c.getString(c.getColumnIndex(user_name));
                int id = c.getInt(c.getColumnIndex(user_id));
                int age = c.getInt(c.getColumnIndex(user_age));
                User user = new User(id,name,age);
                userList.add(user);

            }
            while (c.moveToNext());

        };

        return userList;
//        c.getColumnName(1);
//        c.getColumnNames();
    }
}
