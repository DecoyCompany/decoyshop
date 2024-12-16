package com.example.myapplication.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;


public class Stock extends base_entity
{
    @JsonBackReference("sirket-stock")
    private Sirket sirket;

    @JsonBackReference("urun-stock")
    private Urun urun;

    private String aciklama;

    private int stok = 0;

    private Float fiyat = 0.0F;

    private Float indirim_orani = 1F;

    public Sirket getSirket() {
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public Float getFiyat() {
        return fiyat;
    }

    public void setFiyat(Float fiyat) {
        this.fiyat = fiyat;
    }

    public Float getIndirim_orani() {
        return indirim_orani;
    }

    public void setIndirim_orani(Float indirim_orani) {
        this.indirim_orani = indirim_orani;
    }
}
