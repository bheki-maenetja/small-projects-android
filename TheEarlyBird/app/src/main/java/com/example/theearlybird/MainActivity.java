package com.example.theearlybird;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.theearlybird.Models.Article;
import com.example.theearlybird.Models.NewsApiResponse;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener {
    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading news articles");
        dialog.show();

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener, "general", null);
    }

    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onError(String message) {

        }

        @Override
        public void onFetchData(List<Article> list, String message) {
            showNews(list);
            dialog.dismiss();
        }
    };

    private void showNews(List<Article> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new CustomAdapter(this, list, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnNewsClicked(Article headlines) {
        startActivity(new Intent(MainActivity.this, DetailsActivity.class)
        .putExtra("data", headlines));
    }
}