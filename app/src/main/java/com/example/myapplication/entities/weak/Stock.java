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
