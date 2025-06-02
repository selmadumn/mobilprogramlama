package com.example.hazir_mesajlar_seninle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MessageActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        ListView listViewMessages = findViewById(R.id.listViewMessages);
        TextView textViewCategory = findViewById(R.id.textViewCategory);

        // Kullanıcının seçtiği kategori bilgisini al
        String category = getIntent().getStringExtra("CATEGORY");
        textViewCategory.setText("Kategori: " + category);

        // Seçilen kategoriye ait mesajları FakeData sınıfından al
        List<String> messages = FakeData.getMessagesByCategory(category);

        // Özel liste adaptörünü oluştur ve mesajları ekrana yazdır
        MessageListAdapter adapter = new MessageListAdapter(this, messages);
        listViewMessages.setAdapter(adapter);

        // Mesajlara tıklandığında paylaşma özelliği
        listViewMessages.setOnItemClickListener((parent, view, position, id) -> {
            String selectedMessage = messages.get(position);
            shareMessage(selectedMessage);
        });
    }

    // Seçilen mesajı paylaşma fonksiyonu
    private void shareMessage(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(intent, "Mesajı Paylaş"));
    }
}