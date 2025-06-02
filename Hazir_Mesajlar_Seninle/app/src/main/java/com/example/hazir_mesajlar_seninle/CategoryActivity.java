package com.example.hazir_mesajlar_seninle;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        findViewById(R.id.button_tebrik).setOnClickListener(v -> openMessageScreen("Tebrik"));
        findViewById(R.id.button_sevgili).setOnClickListener(v -> openMessageScreen("Sevgili Mesajları"));
        findViewById(R.id.button_bayram).setOnClickListener(v -> openMessageScreen("Bayram Mesajları"));
        findViewById(R.id.button_gunaydin).setOnClickListener(v -> openMessageScreen("Günaydın"));
        findViewById(R.id.button_ozur).setOnClickListener(v -> openMessageScreen("Özür Mesajları"));
        findViewById(R.id.button_is).setOnClickListener(v -> openMessageScreen("İş Mesajları"));
        findViewById(R.id.button_dogumgunu).setOnClickListener(v -> openMessageScreen("Doğum Günü"));
        findViewById(R.id.button_yeniyil).setOnClickListener(v -> openMessageScreen("Yeni Yıl"));
        findViewById(R.id.button_tesekkur).setOnClickListener(v -> openMessageScreen("Teşekkür"));
        findViewById(R.id.button_genel).setOnClickListener(v -> openMessageScreen("Genel"));
    }

    private void openMessageScreen(String category) {
        Intent intent = new Intent(this, MessageActivity.class);
        intent.putExtra("CATEGORY", category);
        startActivity(intent);
    }
}