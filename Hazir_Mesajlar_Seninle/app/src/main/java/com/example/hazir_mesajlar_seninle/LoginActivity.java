package com.example.hazir_mesajlar_seninle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextName = findViewById(R.id.editTextName);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(v -> {
            String name = editTextName.getText().toString().trim();

            if (name.isEmpty()) {
                editTextName.setError("Lütfen adınızı giriniz");
                Toast.makeText(LoginActivity.this, "Ad alanı boş bırakılamaz!", Toast.LENGTH_SHORT).show();
            } else {
                hideKeyboard();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("user_name", name);
                startActivity(intent);
                finish();
            }
        });
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}