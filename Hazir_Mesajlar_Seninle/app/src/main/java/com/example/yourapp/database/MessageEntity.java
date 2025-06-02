package com.example.yourapp.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity(tableName = "messages")
public class MessageEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "message")
    public String message;

    public MessageEntity(String message) {
        this.message = message;
    }
}
