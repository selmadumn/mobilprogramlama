package com.example.paka_eslesme;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;
    Button btnGeriDon;
    ArrayList<String> liste;
    ArrayAdapter<String> adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.listview);
        btnGeriDon = findViewById(R.id.button3);

        liste = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, liste);
        listView.setAdapter(adapter);

        boolean dogruMu = getIntent().getBooleanExtra("dogruMu", false);
        String sehir = getIntent().getStringExtra("sehir");
        long sure = getIntent().getLongExtra("sure", 0);

        if (dogruMu) {
            liste.add(sehir + " - " + sure + " saniye");
        } else {
            liste.add("Yanlış tahmin!");
        }

        adapter.notifyDataSetChanged();

        btnGeriDon.setOnClickListener(v -> finish());
    }
}