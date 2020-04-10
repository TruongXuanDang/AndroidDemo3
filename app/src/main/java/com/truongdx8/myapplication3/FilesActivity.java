package com.truongdx8.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class FilesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);

        SharedPreferences settings = getSharedPreferences("SS8",MODE_PRIVATE);
        String user = settings.getString("USER","");

        TextView tvTitle = findViewById(R.id.tvDestination);
        tvTitle.setText(user);
    }
}
