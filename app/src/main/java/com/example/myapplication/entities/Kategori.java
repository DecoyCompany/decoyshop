package com.example.myapplication.entities;

import java.util.List;


public class Kategori extends base_entity
{
    private String KATEGORI_ISMI;

    private int KATEGORI_STOK = 0;

    private Kategori ust_kategori;

    private List<Kategori> alt_kategoriler;

    public String getKATEGORI_ISMI() {
        return KATEGORI_ISMI;
    }

    public void setKATEGORI_ISMI(String KATEGORI_ISMI) {
        this.KATEGORI_ISMI = KATEGORI_ISMI;
    }

    public int getKATEGORI_STOK() {
        return KATEGORI_STOK;
    }

    public void setKATEGORI_STOK(int KATEGORI_STOK) {
        this.KATEGORI_STOK = KATEGORI_STOK;
    }

    public Kategori getUst_kategori() {
        return ust_kategori;
    }

    public void setUst_kategori(Kategori ust_kategori) {
        this.ust_kategori = ust_kategori;
    }

    public List<Kategori> getAlt_kategoriler() {
        return alt_kategoriler;
    }

    public void setAlt_kategoriler(List<Kategori> alt_kategoriler) {
        this.alt_kategoriler = alt_kategoriler;
    }
}
