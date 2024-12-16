package com.example.myapplication.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

public class Kullanici extends base_entity
{
    private String kullanici_adi;

    private String email;

    private String sifre;

    private List<String> kart_bilgisi;

    private List<String> adres_bilgisi;

    @JsonManagedReference("siparis-kullanıcı")
    private List<Siparis> siparisler;

    @JsonManagedReference("yorum-kullanici")
    private List<Yorum> yorumlar;

    private List<Urun> favoriler;

    private List<Urun> sepet;

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public List<String> getKart_bilgisi() {
        return kart_bilgisi;
    }

    public void setKart_bilgisi(List<String> kart_bilgisi) {
        this.kart_bilgisi = kart_bilgisi;
    }

    public List<String> getAdres_bilgisi() {
        return adres_bilgisi;
    }

    public void setAdres_bilgisi(List<String> adres_bilgisi) {
        this.adres_bilgisi = adres_bilgisi;
    }

    public List<Siparis> getSiparisler() {
        return siparisler;
    }

    public void setSiparisler(List<Siparis> siparisler) {
        this.siparisler = siparisler;
    }

    public List<Yorum> getYorumlar() {
        return yorumlar;
    }

    public void setYorumlar(List<Yorum> yorumlar) {
        this.yorumlar = yorumlar;
    }

    public List<Urun> getFavoriler() {
        return favoriler;
    }

    public void setFavoriler(List<Urun> favoriler) {
        this.favoriler = favoriler;
    }

    public List<Urun> getSepet() {
        return sepet;
    }

    public void setSepet(List<Urun> sepet) {
        this.sepet = sepet;
    }
}
