package com.example.myapplication.ui.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.ui.login.LoginActivity; // Login sayfası sınıfını buraya ekleyin
import com.example.myapplication.ui.myaccount.MyAccountActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // activity_login.xml layout dosyasını kullanıyoruz


    }
}
