package com.example.publicnewsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {

    Button btn_readNews, btn_generalNews, btn_publishNews,btn_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btn_readNews = findViewById(R.id.btn_readNews);
        btn_publishNews = findViewById(R.id.btn_publishNews);
        btn_generalNews = findViewById(R.id.btn_generalNews);
        btn_profile=findViewById(R.id.btn_profile);

        btn_readNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, ReadNews.class));
            }
        });
        btn_publishNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, PublishNews.class));
            }
        });
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, ProfileActivity.class));
            }
        });
        btn_generalNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, MainActivity.class));
            }
        });

    }
}