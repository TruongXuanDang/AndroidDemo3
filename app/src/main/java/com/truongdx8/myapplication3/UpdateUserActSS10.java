package com.truongdx8.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class UpdateUserActSS10 extends AppCompatActivity implements View.OnClickListener {

    private DBHelperSS10 db;
    UserItem user = new UserItem();

    EditText tvName;
    EditText tvGender;
    EditText tvDescription;
    Button btUpdate;
    Button btDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_act_s_s10);

        db = new DBHelperSS10(this);
        db.getWritableDatabase();

        Intent intent = getIntent();
        int identity = intent.getIntExtra("identityValue",0);

        user = db.getItem(identity);

        initView();

        tvName.setText(user.getName());
        tvGender.setText(user.getGender());
        tvDescription.setText(user.getDescription());


    }

    private void initView()
    {
        tvName = findViewById(R.id.etUserName);
        tvGender = findViewById(R.id.etGender);
        tvDescription = findViewById(R.id.etDescription);

        btUpdate = findViewById(R.id.btUpdate);
        btUpdate.setOnClickListener(this);
        btDelete = findViewById(R.id.btDelete);
        btDelete.setOnClickListener(this);
    }

    private UserItem newUserItem()
    {
        UserItem newUser = new UserItem(user.getId(),tvName.getText().toString(),tvGender.getText().toString(),tvDescription.getText().toString());
        return newUser;
    }

    private void onUpdate(UserItem user)
    {
        String mes = db.updateData(user);
        Toast.makeText(this,mes, Toast.LENGTH_SHORT).show();
        finish();
    }

    private void onDelete(int id)
    {
        String mes = db.deleteData(id);
        Toast.makeText(this,mes, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btUpdate:
                onUpdate(newUserItem());
                break;
            case R.id.btDelete:
                onDelete(user.getId());
                break;
            default:
                break;
        }
    }
}
