package com.example.hazir_mesajlar_seninle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseHalper dbHelper;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeText = findViewById(R.id.welcomeText);
        Button buttonContinue = findViewById(R.id.buttonContinue);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("user_name");

        if (userName != null && !userName.isEmpty()) {
            welcomeText.setText("Hoş geldin, " + userName + "! 🎉");
        }

        buttonContinue.setOnClickListener(v -> {
            Intent categoryIntent = new Intent(MainActivity.this, CategoryActivity.class);
            startActivity(categoryIntent);
        });

        Button buttonFavorites = findViewById(R.id.buttonFavorites);

        buttonFavorites.setOnClickListener(v -> {
            Intent favoriteIntent = new Intent(MainActivity.this, FavoriteActivity.class);
            startActivity(favoriteIntent);
        });
        // 📌 1️⃣ Veritabanını Başlat
        dbHelper = new DatabaseHalper();

        // 📌 2️⃣ Mesaj Ekleme Butonu
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button buttonSaveMessage = findViewById(R.id.button_genel); // XML dosyanla eşleştir!


        // 📌 3️⃣ Mesajları Gösteren Alanı Güncelle
        updateMessagesText();
    }

    // 📌 4️⃣ Mesajları Çekip Ekranda Gösterme Metodu
    private void updateMessagesText() {
        TextView messagesText = findViewById(R.id.messagesText); // XML dosyanla eşleştir!
        List<String> messages = dbHelper.getAllMessages();
        StringBuilder messageBuilder = new StringBuilder();

        for (String msg : messages) {
            messageBuilder.append(msg).append("\n");
        }

        messagesText.setText(messageBuilder.toString());


    }


    private class DatabaseHalper {
        public List<String> getAllMessages() {
            return java.util.Collections.emptyList();
        }
    }
}