package com.example.hazirmesajlar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextName;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextName = findViewById(R.id.editTextName);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();

                if (name.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Lütfen adınızı giriniz", Toast.LENGTH_SHORT).show();
                } else {
                    // Kullanıcı adı ile MainActivity'e geçiş
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("user_name", name);
                    startActivity(intent);
                    finish(); // Geriye dönülmesini engellemek için
                }
            }
        });
    }
}
