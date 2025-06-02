package com.example.hazir_mesajlar_seninle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;

public class FavoriteManager {
    private static final String PREFS_NAME = "favorites_prefs";
    private static final String FAVORITES_KEY = "favorites";

    @SuppressLint("MutatingSharedPrefs")
    public static void addFavorite(Context context, String message) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Set<String> favorites = prefs.getStringSet(FAVORITES_KEY, new HashSet<>());
        favorites.add(message);
        prefs.edit().putStringSet(FAVORITES_KEY, favorites).apply();
    }

    @SuppressLint("MutatingSharedPrefs")
    public static void removeFavorite(Context context, String message) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Set<String> favorites = prefs.getStringSet(FAVORITES_KEY, new HashSet<>());
        favorites.remove(message);
        prefs.edit().putStringSet(FAVORITES_KEY, favorites).apply();
    }

    public static Set<String> getFavorites(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return prefs.getStringSet(FAVORITES_KEY, new HashSet<>());
    }
}