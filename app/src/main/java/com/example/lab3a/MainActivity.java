package com.example.lab3a;

import android.os.Bundle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        Button nextButton = findViewById(R.id.nextButton);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String savedName = sharedPreferences.getString("userName", "");
        if (!savedName.isEmpty()) {
            nameEditText.setText(savedName);
        }

        nextButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, NameActivity.class);
            intent.putExtra("userName", name);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userName", nameEditText.getText().toString());
        editor.apply();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 0) {
                // User wants to change their name, do nothing
            } else if (resultCode == 1) {
                // User is happy with the name, finish the activity
                finish();
            }
        }
    }
}