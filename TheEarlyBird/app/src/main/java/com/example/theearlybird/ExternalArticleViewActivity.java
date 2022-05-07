package com.example.theearlybird;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ExternalArticleViewActivity extends AppCompatActivity {
    private WebView webView;
    String articleUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        articleUrl = (String) getIntent().getSerializableExtra("article-url");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_article_view);

        webView = (WebView) findViewById(R.id.external_article_view);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(articleUrl);

        WebSettings webSettings = webView.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}