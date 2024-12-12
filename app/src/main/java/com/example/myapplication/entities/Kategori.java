package com.example.myapplication.entities;



import java.util.List;


public class Kategori extends base_entity
{


    private String KATEGORI_ISMI;

    private int KATEGORI_STOK = 0;


    private Kategori ust_kategori;

    private List<Kategori> alt_kategoriler;
}
