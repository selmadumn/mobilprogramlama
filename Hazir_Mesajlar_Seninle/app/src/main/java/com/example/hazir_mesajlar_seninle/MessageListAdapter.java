package com.example.hazir_mesajlar_seninle;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.List;

public class MessageListAdapter extends ArrayAdapter<String> {

    public MessageListAdapter(Context context, List<String> messages) {
        super(context, 0, messages);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_message, parent, false);
        }



        String message = getItem(position);
        TextView messageText = convertView.findViewById(R.id.textViewMessage);
        ImageView favoriteIcon = convertView.findViewById(R.id.favoriteIcon);

        messageText.setText(message);

        // 🔥 Mesaja tıklayınca otomatik olarak panoya kopyalasın
        messageText.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Mesaj", message);
            clipboard.setPrimaryClip(clip);

            Log.e("ClipboardTest", "Mesaj panoya kopyalandı: " + message);

            // 🔥 Kopyalanan metni geri almak ve kontrol etmek için eklenen kod
            if (clipboard.hasPrimaryClip()) {
                ClipData data = clipboard.getPrimaryClip();
                if (data != null && data.getItemCount() > 0) {
                    String copiedText = data.getItemAt(0).getText().toString();
                    Log.d("ClipboardTest", "Panoya eklenen mesaj: " + copiedText);
                }
            }



            // 🔥 Kopyalanan metni geri almak ve kontrol etmek için eklenen kod
            if (clipboard.hasPrimaryClip()) {
                ClipData data = clipboard.getPrimaryClip();
                if (data != null && data.getItemCount() > 0) {
                    String copiedText = data.getItemAt(0).getText().toString();
                    Log.d("ClipboardTest", "Panoya eklenen mesaj: " + copiedText);
                }
            }

            Toast.makeText(v.getContext(), "Mesaj kopyalandı!", Toast.LENGTH_SHORT).show();
        });



        // 🔥 Paylaş butonu ekleyelim
        messageText.setOnLongClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, message);
            v.getContext().startActivity(Intent.createChooser(shareIntent, "Mesajı Paylaş"));
            return true;
        });




        // Favori olup olmadığını kontrol et
        if (FavoriteManager.getFavorites(getContext()).contains(message)) {
            favoriteIcon.setImageResource(R.drawable.ic_favorite_filled);
        } else {
            favoriteIcon.setImageResource(R.drawable.ic_favorite_border);
        }

        // Favoriye ekleme veya çıkarma işlemi
        favoriteIcon.setOnClickListener(v -> {
            if (FavoriteManager.getFavorites(getContext()).contains(message)) {
                FavoriteManager.removeFavorite(getContext(), message);
                favoriteIcon.setImageResource(R.drawable.ic_favorite_border);
            } else {
                FavoriteManager.addFavorite(getContext(), message);
                favoriteIcon.setImageResource(R.drawable.ic_favorite_filled);
            }
        });
        




        return convertView;
    }


}