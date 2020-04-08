package com.truongdx8.myapplication3;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<WeatherItem> weatherItems;
    public String url = "https://developer.accuweather.com/sites/default/files/";

    public WeatherAdapter(Activity activity, List<WeatherItem> weatherItems) {
        this.activity = activity;
        this.weatherItems = weatherItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = activity.getLayoutInflater().inflate(R.layout.activity_weatheritem,parent,false);
        WeatherHolder holder = new WeatherHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        WeatherHolder weatherHolder = (WeatherHolder) holder;
        WeatherItem data = weatherItems.get(position);

        DecimalFormat df = new DecimalFormat("00");
        String iconNo = df.format(data.getWeatherIcon());
        String imageURL = url + iconNo + "-s.png";

        Glide.with(activity).load(imageURL).into(weatherHolder.ivImage);
        weatherHolder.tvDate.setText(convertTime(data.getDateTime()));
        weatherHolder.tvTemperature.setText(Float.toString(data.getTemperature().getValue()));
    }

    @Override
    public int getItemCount() {
        return weatherItems.size();
    }

    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        String goal = outFormat.format(date);
        return goal;
    }

}
