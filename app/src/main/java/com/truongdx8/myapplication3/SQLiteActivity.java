package com.truongdx8.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class SQLiteActivity extends AppCompatActivity {
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_q_lite);

        db = new DBHelper(this);
        db.getWritableDatabase();

//        insertUser();
        //updateUser();
        //deleteUser();
        getAllUser();
    }

    private void insertUser()
    {
        for(int i=0;i<10;i++)
        {
            User user = new User("Nguyen Van "+i,20+i);
            db.insertData(user);

        }

    }

    private void updateUser()
    {
        User user = new User();
        user.setId(5);
        user.setName("Tran Van Nam");
        String mes = db.updateData(user);
        Toast.makeText(this,mes, Toast.LENGTH_SHORT).show();
    }

    private void deleteUser()
    {
        String mes = db.deleteData(10);
        Toast.makeText(this,mes, Toast.LENGTH_SHORT).show();
    }

    private void getAllUser()
    {
        List<User> list = db.getData();
        for (User u : list)
        {
            Log.d("getAllUser"," Name: "+u.getName()+"id: "+u.getId()+" age: "+u.getAge());
        }

    }
}
