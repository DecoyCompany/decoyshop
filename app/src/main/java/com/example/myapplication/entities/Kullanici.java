package com.example.myapplication.entities;

import com.example.myapplication.entities.weak.Siparis;
import com.example.myapplication.entities.weak.Yorum;


import java.util.List;



public class Kullanici extends base_entity
{

    private String kullanici_adi;

    private String email;

    private String sifre;




    private List<String> kart_bilgisi;

    private List<String> adres_bilgisi;


    private List<Siparis> siparisler;

    private List<Yorum> yorumlar;

    private List<Urun> favoriler;
}
