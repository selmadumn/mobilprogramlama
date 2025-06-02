package com.example.hazir_mesajlar_seninle;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        ListView listViewFavorites = findViewById(R.id.listViewFavorites);

        // Favorite çek ve ekrana listele
        Set<String> favoriteMessages = FavoriteManager.getFavorites(this);
        List<String> favoriteList = new ArrayList<>(favoriteMessages);
        listViewFavorites.setAdapter(new MessageListAdapter(this, favoriteList));
    }
}
