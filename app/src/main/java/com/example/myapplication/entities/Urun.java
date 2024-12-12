package com.example.myapplication.entities;
import com.example.myapplication.entities.weak.Stock;
import com.example.myapplication.entities.weak.Yorum;



import java.util.List;


public class Urun extends base_entity
{

    private String URUN_AD;

    private float URUN_PUANI;

    private List<String> etiketler;

    private List<String> resimler;

    private Kategori URUN_KATEGORISI;

    private List<Yorum> yorumlar;

    private List<Urun> oneriler;

    private List<Stock> stoklar;

    private List<Kullanici> favoriOlanKullanicilar;
}
