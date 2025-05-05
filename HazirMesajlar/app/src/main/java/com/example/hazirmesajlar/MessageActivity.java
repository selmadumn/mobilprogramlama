package com.example.hazirmesajlar;
import com.example.hazirmesajlar.Message;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.stream.Collectors;

public class MessageActivity extends AppCompatActivity {

    private ListView listViewMessages;
    private TextView textViewCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        listViewMessages = findViewById(R.id.listViewMessages);
        textViewCategory = findViewById(R.id.textViewCategory);

        String category = getIntent().getStringExtra("selected_category");

        if (category != null) {
            textViewCategory.setText("Kategori: " + category);

            List<Message> messages = FakeData.getMessagesByCategory(category);
            List<String> messageContents = messages.stream()
                    .map(Message::getContent)
                    .collect(Collectors.toList());

            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    messageContents
            );
            listViewMessages.setAdapter(adapter);
        }
    }
}
