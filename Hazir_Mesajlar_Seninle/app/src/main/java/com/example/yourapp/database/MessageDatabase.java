package com.example.yourapp.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {MessageEntity.class}, version = 1)
public abstract class MessageDatabase extends RoomDatabase {
    public abstract MessageDao messageDao();

    private static MessageDatabase INSTANCE;

    public static MessageDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MessageDatabase.class, "message_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
