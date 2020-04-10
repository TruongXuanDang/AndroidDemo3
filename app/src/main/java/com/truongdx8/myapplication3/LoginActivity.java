package com.truongdx8.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edUser, edPassword;
    Button btLogin,btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUser = findViewById(R.id.edUser);
        edPassword = findViewById(R.id.edPassword);
        btLogin = findViewById(R.id.btLogin);
        btRegister = findViewById(R.id.btRegister);

        btLogin.setOnClickListener(this);
        btRegister.setOnClickListener(this);

        checkLogin();
    }

    private void checkLogin()
    {
        SharedPreferences settings = getSharedPreferences("SS8",MODE_PRIVATE);
        //String user = settings.getString("USER","");
        boolean isLogin = settings.getBoolean("IS_LOGIN",false);

        if(isLogin){
            Intent intent = new Intent(LoginActivity.this,FilesActivity.class   );
            //intent.putExtra("USER_DATA", user);
            startActivity(intent);
            finish();
        }
    }

    private void onLogin()
    {
        SharedPreferences settings = getSharedPreferences("SS8",MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        //data nay luu o Device File Explorer => Data => Data => Ten ung dung (May ao)
        // Co the ma hoa bang sha256
        editor.putString("USER",edUser.getText().toString());
        editor.putBoolean("IS_LOGIN",true);
        editor.commit();

        Intent intent = new Intent(LoginActivity.this,FilesActivity.class   );
        startActivity(intent);
    }

    private void onRegister()
    {

    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btLogin:
                onLogin();
                break;

            case R.id.btRegister:
                onRegister();
                break;
        }
    }
}
