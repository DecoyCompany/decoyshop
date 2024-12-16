package com.example.myapplication.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


public class Kategori extends base_entity
{
    private String KATEGORI_ISMI;

    private int KATEGORI_STOK = 0;

    @JsonBackReference("alt-ust_kategori")
    private Kategori ustKategori;

    @JsonManagedReference("alt-ust_kategori")
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

    public Kategori getUstKategori() {
        return ustKategori;
    }

    public void setUstKategori(Kategori ust_kategori) {
        this.ustKategori = ust_kategori;
    }

    public List<Kategori> getAlt_kategoriler() {
        return alt_kategoriler;
    }

    public void setAlt_kategoriler(List<Kategori> alt_kategoriler) {
        this.alt_kategoriler = alt_kategoriler;
    }
}
