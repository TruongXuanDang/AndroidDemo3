package com.truongdx8.myapplication3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiManager {
    String SERVER = "http://tommyprivateguide.com";

    @GET("/datas.json")
    Call<List<PostItem>> getListNews();
}
