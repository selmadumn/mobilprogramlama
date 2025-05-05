package com.example.hazirmesajlar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView welcomeText;
    private Button buttonContinue;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeText = findViewById(R.id.welcomeText);
        buttonContinue = findViewById(R.id.buttonContinue);

        // LoginActivity'den gelen kullanıcı adını al
        Intent intent = getIntent();
        userName = intent.getStringExtra("user_name");

        if (userName != null && !userName.isEmpty()) {
            welcomeText.setText("Hoş geldin, " + userName + "!");
        }

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CategoryActivity'e geç
                Intent categoryIntent = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(categoryIntent);
            }
        });
    }
}
