package com.example.myapplication.entities.weak;
import com.example.myapplication.entities.*;


import java.util.Date;
import java.util.List;

public class Yorum extends base_entity
{

    private Urun urun;

    private Kullanici yorumcu;

    private float puan;


    private String yazi;

    private Date tarih = new Date();

    private List<String> resimler;


    private Yorum cevap;


    private boolean sorumu;
}
