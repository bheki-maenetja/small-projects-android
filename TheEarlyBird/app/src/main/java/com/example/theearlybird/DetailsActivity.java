package com.example.theearlybird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.theearlybird.Models.Article;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    Article headlines;
    TextView txt_title, txt_author, txt_time, txt_detail, txt_content;
    ImageView img_news;
    Button externalLinkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txt_title = findViewById(R.id.text_detail_title);
        txt_author = findViewById(R.id.text_detail_author);
        txt_time = findViewById(R.id.text_detail_time);
        txt_detail = findViewById(R.id.text_detail_detail);
        txt_content = findViewById(R.id.text_detail_content);
        img_news = findViewById(R.id.img_detail_news);
        externalLinkBtn = findViewById(R.id.externalLink);

        headlines = (Article) getIntent().getSerializableExtra("data");

        txt_title.setText(headlines.getTitle());
        txt_author.setText(headlines.getAuthor());
        txt_time.setText(headlines.getPublishedAt());
        txt_detail.setText(headlines.getDescription());
        txt_content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);
        
        externalLinkBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(headlines.getUrl()));
                startActivity(i);
//                startActivity(new Intent(DetailsActivity.this, ExternalArticleViewActivity.class)
//                        .putExtra("article-url", headlines.getUrl()));
            }
        });
    }
}