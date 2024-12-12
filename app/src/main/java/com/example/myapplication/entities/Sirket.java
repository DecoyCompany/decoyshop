package com.example.myapplication.entities;



import com.example.myapplication.entities.weak.Stock;
import com.example.myapplication.entities.weak.Siparis;

import java.util.List;

public class Sirket extends base_entity
{

    private String SIRKET_ISMI;


    private String SIRKET_ADRESI;

    private String ILETISIM_NO;

    private List<Siparis> siparisler;

    private List<Stock> stocklar;

}
