package com.example.myapplication.entities;
import com.example.myapplication.entities.weak.Stock;
import com.example.myapplication.entities.weak.Yorum;



import java.util.List;


public class Urun extends base_entity
{

    private String URUN_AD;

    private float URUN_PUANI;

    private List<String> etiketler;

    private List<String> resimler;

    private Kategori URUN_KATEGORISI;

    private List<Yorum> yorumlar;

    private List<Urun> oneriler;

    private List<Stock> stoklar;

    private List<Kullanici> favoriOlanKullanicilar;

    public String getURUN_AD() {
        return URUN_AD;
    }

    public void setURUN_AD(String URUN_AD) {
        this.URUN_AD = URUN_AD;
    }

    public float getURUN_PUANI() {
        return URUN_PUANI;
    }

    public void setURUN_PUANI(float URUN_PUANI) {
        this.URUN_PUANI = URUN_PUANI;
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

    public Kategori getURUN_KATEGORISI() {
        return URUN_KATEGORISI;
    }

    public void setURUN_KATEGORISI(Kategori URUN_KATEGORISI) {
        this.URUN_KATEGORISI = URUN_KATEGORISI;
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

    public List<Kullanici> getFavoriOlanKullanicilar() {
        return favoriOlanKullanicilar;
    }

    public void setFavoriOlanKullanicilar(List<Kullanici> favoriOlanKullanicilar) {
        this.favoriOlanKullanicilar = favoriOlanKullanicilar;
    }
}
