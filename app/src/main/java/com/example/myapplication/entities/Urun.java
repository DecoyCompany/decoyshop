package com.example.myapplication.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;


public class Urun extends base_entity
{

    private String URUN_AD;

    private float urunPuani;

    private List<String> etiketler;

    private List<String> resimler;

    private Kategori urunKategorisi;

    @JsonManagedReference("yorum-urun")
    private List<Yorum> yorumlar;

    @JsonIgnore
    private List<Urun> oneriler;

    @JsonManagedReference("urun-stock")
    private List<Stock> stoklar;

    public String getURUN_AD() {
        return URUN_AD;
    }

    public void setURUN_AD(String URUN_AD) {
        this.URUN_AD = URUN_AD;
    }

    public float getUrunPuani() {
        return urunPuani;
    }

    public void setUrunPuani(float urunPuani) {
        this.urunPuani = urunPuani;
    }

    public List<String> getEtiketler() {
        return etiketler;
    }

    public void setEtiketler(List<String> etiketler) {
        this.etiketler = etiketler;
    }

    public List<String> getResimler() {
        return resimler;
    }

    public void setResimler(List<String> resimler) {
        this.resimler = resimler;
    }

    public Kategori getUrunKategorisi() {
        return urunKategorisi;
    }

    public void setUrunKategorisi(Kategori urunKategorisi) {
        this.urunKategorisi = urunKategorisi;
    }

    public List<Yorum> getYorumlar() {
        return yorumlar;
    }

    public void setYorumlar(List<Yorum> yorumlar) {
        this.yorumlar = yorumlar;
    }

    public List<Urun> getOneriler() {
        return oneriler;
    }

    public void setOneriler(List<Urun> oneriler) {
        this.oneriler = oneriler;
    }

    public List<Stock> getStoklar() {
        return stoklar;
    }

    public void setStoklar(List<Stock> stoklar) {
        this.stoklar = stoklar;
    }

}
