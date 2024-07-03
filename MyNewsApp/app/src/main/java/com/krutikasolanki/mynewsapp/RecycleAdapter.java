package com.krutikasolanki.mynewsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.krutikasolanki.mynewsapp.repository.model.Article;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    Context context;
    List<Article> articles;

    public RecycleAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.time.setText("Published at: " + articles.get(position).getPublishedAt().substring(11, 19));
        holder.author.setText(articles.get(position).getAuthor());
        holder.heading.setText(articles.get(position).getTitle());

        // For some news, the description is null
        if (articles.get(position).getDescription() != null)
            holder.content.setText(articles.get(position).getDescription());
        else
            holder.content.setText("Description Not Available");

        // For some news, the image is null
        if (articles.get(position).getUrlToImage() != null)
            Picasso.get().load(articles.get(position).getUrlToImage()).into(holder.imageView);
        else
            Picasso.get().load(R.drawable.download).into(holder.imageView);

        holder.newscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebView.class);
                intent.putExtra("url", articles.get(position).getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heading, content, author, time;
        CardView newscard;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.mainHeading);
            content = itemView.findViewById(R.id.content);
            author = itemView.findViewById(R.id.author);
            time = itemView.findViewById(R.id.time);
            newscard = itemView.findViewById(R.id.newscard);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
