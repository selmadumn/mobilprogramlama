package com.example.hazirmesajlar;

public class Message {
    private String content;
    private String kategori;

    public Message(String content, String kategori) {
        this.content = content;
        this.kategori = kategori;
    }

    public String getContent() {
        return content;
    }

    public String getKategori() {
        return kategori;
    }
}
