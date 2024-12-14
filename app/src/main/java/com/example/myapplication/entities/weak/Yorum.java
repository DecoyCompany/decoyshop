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

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public Kullanici getYorumcu() {
        return yorumcu;
    }

    public void setYorumcu(Kullanici yorumcu) {
        this.yorumcu = yorumcu;
    }

    public float getPuan() {
        return puan;
    }

    public void setPuan(float puan) {
        this.puan = puan;
    }

    public String getYazi() {
        return yazi;
    }

    public void setYazi(String yazi) {
        this.yazi = yazi;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public List<String> getResimler() {
        return resimler;
    }

    public void setResimler(List<String> resimler) {
        this.resimler = resimler;
    }

    public Yorum getCevap() {
        return cevap;
    }

    public void setCevap(Yorum cevap) {
        this.cevap = cevap;
    }

    public boolean isSorumu() {
        return sorumu;
    }

    public void setSorumu(boolean sorumu) {
        this.sorumu = sorumu;
    }
}
