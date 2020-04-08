package com.truongdx8.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherActivity extends AppCompatActivity {
    List<WeatherItem> list = new ArrayList<>();
    TextView tvTemperature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        tvTemperature = findViewById(R.id.tvTemperature);

        getData();

    }

    private void getData()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.WEATHERSERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiManager apiManager = retrofit.create(ApiManager.class);
        apiManager.getWeatherItems().enqueue(new Callback<List<WeatherItem>>() {

            @Override
            public void onResponse(Call<List<WeatherItem>> call, Response<List<WeatherItem>> response) {
                list = response.body();
                WeatherAdapter adapter = new WeatherAdapter(WeatherActivity.this,list);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(WeatherActivity.this, LinearLayoutManager.HORIZONTAL,false);

                tvTemperature.setText(Float.toString(list.get(0).getTemperature().getValue())+"°C");

                RecyclerView rvWeather = findViewById(R.id.rvWeather);
                rvWeather.setLayoutManager(layoutManager);
                rvWeather.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<WeatherItem>> call, Throwable t) {

            }
        });
    }
}
