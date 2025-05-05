package com.example.hazirmesajlar;

import com.example.hazirmesajlar.Message;

import java.util.ArrayList;
import java.util.List;

public class FakeData {

    public static List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Tebrik"));
        categories.add(new Category("SevgiliMesajlari"));
        categories.add(new Category("BayramMesajlari"));
        categories.add(new Category("Gunaydin"));
        categories.add(new Category("OzurMesajlari"));
        categories.add(new Category("IsMesajlari"));
        categories.add(new Category("DogumGunu"));
        categories.add(new Category("YeniYil"));
        categories.add(new Category("Tesekkur"));
        categories.add(new Category("Genel"));
        return categories;
    }

    public static List<Message> getMessagesByCategory(String category) {
        List<Message> messages = new ArrayList<>();

        // Basit örnek veri
        if (category.equals("Tebrik")) {
            messages.add(new Message("Tebrikler! Harika bir iş çıkardın.", "Tebrik"));
        } else if (category.equals("Gunaydin")) {
            messages.add(new Message("Günaydın! Yeni bir gün, yeni bir başlangıç.", "Gunaydin"));
        } else {
            messages.add(new Message("Bu kategoriye ait örnek mesaj yok.", category));
        }

        return messages;
    }
}
