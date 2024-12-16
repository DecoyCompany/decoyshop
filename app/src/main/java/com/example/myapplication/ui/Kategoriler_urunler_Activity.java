package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.adapters.urunler_table_adapter;
import com.example.myapplication.adapters.ust_kategoriler_adapter;
import com.example.myapplication.entities.Kategori;
import com.example.myapplication.entities.Urun;
import com.example.myapplication.http_stuff.http_request_builder;
import com.example.myapplication.ui.login.LoginActivity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Kategoriler_urunler_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kategoriler_urunler);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<Kategori> ust_kategoriler = http_request_builder.getUstKategoriler(this);
        if(ust_kategoriler == null)
        {
            Log.e("ust_kategori","ust_kategroi is emtpty !!!");
            Intent intent = new Intent(Kategoriler_urunler_Activity.this, LoginActivity.class);
            startActivity(intent);
        }

        ust_kategoriler_adapter ustKategorilerAdapter = new ust_kategoriler_adapter(this,ust_kategoriler);
        RecyclerView recyclerView_kategoriler = findViewById(R.id.Ust_kategoriler_liste);
        Log.e("ust_kategori",recyclerView_kategoriler.toString());
        recyclerView_kategoriler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView_kategoriler.setAdapter(ustKategorilerAdapter);

        Kategori the_kategori;
        try
        {
            final ObjectMapper mapper = new ObjectMapper();
            the_kategori = mapper.readValue(getIntent().getStringExtra("kategori"),
                    mapper.getTypeFactory().constructType(Kategori.class));
            Kategori the_kategori_parent = mapper.readValue(getIntent().getStringExtra("kategori_parent"),
                    mapper.getTypeFactory().constructType(Kategori.class));
            the_kategori.setUstKategori(the_kategori_parent);
        }
        catch (Exception e)
        {
            Log.e("mapper",e.getMessage());
            the_kategori = null;
        }

        List<Kategori> alt_kategoriler;
        List<Urun> urunler;
        if(the_kategori.getUstKategori() == null)
        {
            alt_kategoriler = the_kategori.getAlt_kategoriler();
            Log.e("the_kategori",the_kategori.getKATEGORI_ISMI() + the_kategori.getAlt_kategoriler().isEmpty());
            Log.e("alt_kategoriler", String.valueOf(alt_kategoriler.isEmpty()));
            urunler = http_request_builder.getUrunlerKategori(this,the_kategori.getAlt_kategoriler().get(0));
        }
        else
        {
            alt_kategoriler = the_kategori.getUstKategori().getAlt_kategoriler();
            urunler = http_request_builder.getUrunlerKategori(this,the_kategori);
        }

        if(alt_kategoriler == null)
        {
            Log.e("alt_kategori","alt_kategroi is emtpty !!!");
            Intent intent = new Intent(Kategoriler_urunler_Activity.this, LoginActivity.class);
            startActivity(intent);
        }

        ust_kategoriler_adapter altKategorilerAdapter = new ust_kategoriler_adapter(this,alt_kategoriler);
        RecyclerView recyclerView_alt_kategoriler = findViewById(R.id.Alt_kategoriler_liste);
        Log.e("alt_kategori",recyclerView_alt_kategoriler.toString());
        recyclerView_alt_kategoriler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView_alt_kategoriler.setAdapter(altKategorilerAdapter);


        if(urunler == null)
        {
            Intent intent = new Intent(Kategoriler_urunler_Activity.this, LoginActivity.class);
            startActivity(intent);
        }

        urunler_table_adapter adapter = new urunler_table_adapter(this, urunler);
        RecyclerView recyclerView_urunler = findViewById(R.id.urunler_liste);
        recyclerView_urunler.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_urunler.setAdapter(adapter);

    }
}