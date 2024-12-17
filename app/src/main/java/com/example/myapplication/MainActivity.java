package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.entities.Kategori;
import com.example.myapplication.entities.Urun;
import com.example.myapplication.ui.login.LoginActivity;
import com.example.myapplication.ui.myaccount.MyAccountActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.http_stuff.http_request_builder;
import com.example.myapplication.adapters.urunler_table_adapter;
import com.example.myapplication.adapters.ust_kategoriler_adapter;
import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Kullanıcı simgesine tıklanma olayını ekleme
        ImageView userIcon = findViewById(R.id.user_icon);
        userIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyAccountActivity.class);
                startActivity(intent);
            }
        });

        List<Kategori> ust_kategoriler = http_request_builder.getUstKategoriler(this);
        if(ust_kategoriler == null)
        {
            Log.e("ust_kategori","ust_kategroi is emtpty !!!");
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        ust_kategoriler_adapter ustKategorilerAdapter = new ust_kategoriler_adapter(this,ust_kategoriler);
        RecyclerView recyclerView_kategoriler = findViewById(R.id.Ust_kategoriler_liste);
        Log.e("ust_kategori",recyclerView_kategoriler.toString());
        recyclerView_kategoriler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView_kategoriler.setAdapter(ustKategorilerAdapter);

        List<Urun> urunler = http_request_builder.getUrunlerPopular(10,this);

        if(urunler == null)
        {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        urunler_table_adapter adapter = new urunler_table_adapter(this, urunler);
        RecyclerView recyclerView_urunler = findViewById(R.id.urunler_liste);
        recyclerView_urunler.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_urunler.setAdapter(adapter);

        // Kategorileri getir
        List<Kategori> kategoriler = http_request_builder.getKategoriler(this);

        if (kategoriler != null) {
            for (Kategori kategori : kategoriler) {
                Log.d("Kategori", "Kategori Adı: " + kategori.getKATEGORI_ISMI());
            }
        } else {
            Log.e("Kategori", "Kategoriler alınırken hata oluştu veya null değer döndü.");
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }


    }
}