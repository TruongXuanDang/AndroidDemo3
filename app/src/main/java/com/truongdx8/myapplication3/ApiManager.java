package com.truongdx8.myapplication3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiManager {
    String SERVER = "http://tommyprivateguide.com";
    String WEATHERSERVER = "http://dataservice.accuweather.com";

    @GET("/datas.json")
    Call<List<PostItem>> getListNews();

    @GET("/forecasts/v1/hourly/12hour/353412?apikey=GxeywLDUyE32YK5THyh9wf8jGqQ2EYpN&language=vi-vn&metric=true")
    Call<List<WeatherItem>> getWeatherItems();
}
