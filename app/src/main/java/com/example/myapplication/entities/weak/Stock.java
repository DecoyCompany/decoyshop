package com.example.myapplication.entities.weak;
import com.example.myapplication.entities.Sirket;
import com.example.myapplication.entities.Urun;
import com.example.myapplication.entities.base_entity;


public class Stock extends base_entity
{

    private Sirket sirket;

    private Urun urun;

    private String aciklama;

    private int stok;

    private Float fiyat;

    private Float indirim_orani;
}
