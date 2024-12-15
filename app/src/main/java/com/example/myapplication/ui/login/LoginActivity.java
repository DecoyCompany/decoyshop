package com.example.myapplication.ui.login;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.myapplication.http_stuff.http_request_builder;
import com.example.myapplication.MainActivity;
import com.example.myapplication.ui.myaccount.MyAccountActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // activity_login.xml layout dosyasını kullanıyoruz

         TextView email_text = findViewById(R.id.email_text);
         TextView password_text = findViewById(R.id.password_text);
         TextView error_text = findViewById(R.id.error_text);

        SharedPreferences preferences = getSharedPreferences("user_data", MODE_PRIVATE);
        String user_mail = preferences.getString("user_mail", null);
        String user_password = preferences.getString("user_password", null);

        if(user_mail != null && user_password != null)
        {
            email_text.setText(user_mail);
            password_text.setText(user_password);
        }


        // "Kayıt ol" butonunu bul ve tıklama işlemini ekle
        Button loginButton = findViewById(R.id.kayıt_ol_yonlendir_button); // Kayıt ol butonunun ID'si
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MyAccountActivity'e geçiş yap
                Intent intent = new Intent(LoginActivity.this, MyAccountActivity.class);
                startActivity(intent);
            }
        });



        findViewById(R.id.giris_yap_button).setOnClickListener(a -> {
            String response = http_request_builder.Login(
                    email_text.getText().toString(),
                    password_text.getText().toString(),
                    this);

            if (response == null || response.isEmpty())
            {
                response = "response come null ??";
            }

            error_text.setText(response);

            if(response.equals("Login successful"))
            {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
