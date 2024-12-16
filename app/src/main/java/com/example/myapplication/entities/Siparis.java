package com.example.myapplication.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;


public class Siparis extends base_entity
{
    @JsonBackReference("sirket-siparis")
    private Sirket sirket;

    private List<Urun> alinan_urunler;

    @JsonBackReference("siparis-kullanıcı")
    private Kullanici alici;

    private String siparisDetay;

    private boolean tamamlandimi = false;

    public Sirket getSirket() {
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }

    public List<Urun> getAlinan_urunler() {
        return alinan_urunler;
    }

    public void setAlinan_urunler(List<Urun> alinan_urunler) {
        this.alinan_urunler = alinan_urunler;
    }

    public Kullanici getAlici() {
        return alici;
    }

    public void setAlici(Kullanici alici) {
        this.alici = alici;
    }

    public String getSiparisDetay() {
        return siparisDetay;
    }

    public void setSiparisDetay(String siparisDetay) {
        this.siparisDetay = siparisDetay;
    }

    public boolean isTamamlandimi() {
        return tamamlandimi;
    }

    public void setTamamlandimi(boolean tamamlandimi) {
        this.tamamlandimi = tamamlandimi;
    }
}
