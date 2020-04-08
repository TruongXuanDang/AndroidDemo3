package com.truongdx8.myapplication3;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<PostItem> postItems;

    public PostAdapter(Activity activity, List<PostItem> postItems) {
        this.activity = activity;
        this.postItems = postItems;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = activity.getLayoutInflater().inflate(R.layout.activity_postitem,parent,false);
        PostHolder holder = new PostHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PostHolder newsHolder = (PostHolder) holder;
        PostItem data = postItems.get(position);

        Glide.with(activity).load(data.getImage()).into(newsHolder.ivCover);
        newsHolder.tvTitle.setText(data.getTitle());
        newsHolder.tvContent.setText(data.getContent());
        newsHolder.tvDate.setText(data.getDate());
    }

    @Override
    public int getItemCount() {
        return postItems.size();
    }
}
