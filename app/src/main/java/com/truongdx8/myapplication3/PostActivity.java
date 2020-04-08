package com.truongdx8.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostActivity extends AppCompatActivity {
    List<PostItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        getData();


    }

    private void getData()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiManager apiManager = retrofit.create(ApiManager.class);
        apiManager.getListNews().enqueue(new Callback<List<PostItem>>() {

            @Override
            public void onResponse(Call<List<PostItem>> call, Response<List<PostItem>> response) {
                list = response.body();
                PostAdapter adapter = new PostAdapter(PostActivity.this,list);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PostActivity.this, LinearLayoutManager.VERTICAL,false);

                RecyclerView rvNews = findViewById(R.id.rvPosts);
                rvNews.setLayoutManager(layoutManager);
                rvNews.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PostItem>> call, Throwable t) {

            }
        });
    }
}
