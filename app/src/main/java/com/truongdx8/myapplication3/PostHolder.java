package com.truongdx8.myapplication3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostHolder extends RecyclerView.ViewHolder {
    ImageView ivCover;
    TextView tvDate;
    TextView tvTitle;
    TextView tvContent;
    public PostHolder(@NonNull View itemView) {
        super(itemView);
        ivCover = itemView.findViewById(R.id.ivCover);
        tvDate = itemView.findViewById(R.id.tvDate);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvContent = itemView.findViewById(R.id.tvContent);
    }
}
