package com.truongdx8.myapplication3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListUserActSS10 extends AppCompatActivity {
    private DBHelperSS10 db;
    ListView lvUser;
    List<UserItem> userList = new ArrayList<>();
    UserAdapter adapter;

    private Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user_act_s_s10);

        db = new DBHelperSS10(this);
        db.getWritableDatabase();

        getAllUser();
    }

    private void getAllUser()
    {
        userList = db.getData();
        adapter = new UserAdapter(this,userList);

        lvUser = findViewById(R.id.lvListUser);
        lvUser.setAdapter(adapter);

        lvUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int _id = userList.get(position).getId();

                Intent intent = new Intent(ListUserActSS10.this,UpdateUserActSS10.class);
                intent.putExtra("identityValue",_id);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        userList = db.getData();
        adapter = new UserAdapter(this,userList);

        lvUser = findViewById(R.id.lvListUser);
        lvUser.setAdapter(adapter);

    }

}
