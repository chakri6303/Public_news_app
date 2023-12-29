package com.example.publicnewsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserDashboard extends AppCompatActivity {

    Button btn_readNews, btn_generalNews, btn_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        btn_readNews = findViewById(R.id.btn_readNews);
        btn_profile = findViewById(R.id.btn_profile);
        btn_generalNews = findViewById(R.id.btn_generalNews);

        btn_readNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashboard.this, ReadNews.class));
            }
        });
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashboard.this, ProfileActivity.class));
            }
        });
        btn_generalNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashboard.this, MainActivity.class));
            }
        });

    }
}