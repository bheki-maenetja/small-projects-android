package com.example.theearlybird;

import com.example.theearlybird.Models.Article;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {
    void onFetchData(List<Article> list, String message);
    void onError(String message);
}
