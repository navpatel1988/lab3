package com.example.lab3a;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        TextView welcomeTextView = findViewById(R.id.welcomeTextView);
        Button dontCallMeButton = findViewById(R.id.dontCallMeButton);
        Button thankYouButton = findViewById(R.id.thankYouButton);

        String userName = getIntent().getStringExtra("userName");
        welcomeTextView.setText("Welcome " + userName + "!");

        dontCallMeButton.setOnClickListener(v -> {
            setResult(0);
            finish();
        });

        thankYouButton.setOnClickListener(v -> {
            setResult(1);
            finish();
        });
    }
}