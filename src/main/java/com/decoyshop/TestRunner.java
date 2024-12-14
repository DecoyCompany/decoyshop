package com.decoyshop;

import com.decoyshop.entities.Kategori;
import com.decoyshop.services.CRUD_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TestRunner implements CommandLineRunner {

    private final CRUD_service crudService;

    @Autowired
    public TestRunner(CRUD_service crudService) {
        this.crudService = crudService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create a test instance of 'Urun'
        // Ana kategoriler
        Kategori elektronik = new Kategori();
        elektronik.setKATEGORI_ISMI("Elektronik");
        elektronik.setKATEGORI_STOK(1000);
        elektronik.setUst_kategori(null); // Ana kategori, ust_kategori_id null

        Kategori giyim = new Kategori();
        giyim.setKATEGORI_ISMI("Giyim");
        giyim.setKATEGORI_STOK(500);
        giyim.setUst_kategori(null); // Ana kategori, ust_kategori_id null


        Kategori oyuncak = new Kategori();
        oyuncak.setKATEGORI_ISMI("Oyuncak");
        oyuncak.setKATEGORI_STOK(1000);
        oyuncak.setUst_kategori(null); // Ana kategori, ust_kategori_id null

        Kategori mobilya = new Kategori();
        mobilya.setKATEGORI_ISMI("Mobilya");
        mobilya.setKATEGORI_STOK(500);
        mobilya.setUst_kategori(null); // Ana kategori, ust_kategori_id null


        Kategori ayakkabi = new Kategori();
        ayakkabi.setKATEGORI_ISMI("Ayakkabı");
        ayakkabi.setKATEGORI_STOK(450);
        ayakkabi.setUst_kategori(null); // Ana kategori, ust_kategori_id null

        Kategori kitap = new Kategori();
        kitap.setKATEGORI_ISMI("Kitap");
        kitap.setKATEGORI_STOK(500);
        kitap.setUst_kategori(null); // Ana kategori, ust_kategori_id null

        // Ana kategorileri kaydet
        /*
        crudService.Create(Arrays.asList(elektronik, giyim, kitap, ayakkabi, oyuncak, mobilya));
        System.out.println("Ana kategoriler kaydedildi.");
        */


        ArrayList<Kategori> kategoris = new ArrayList<>(50);
        kategoris.add(kitap);
        kategoris.add(oyuncak);
        kategoris.add(giyim);
        kategoris.add(mobilya);
        kategoris.add(elektronik);
        kategoris.add(ayakkabi);



        // Alt kategoriler - Elektronik kategorisi altındaki kategoriler
        Kategori telefon = new Kategori();
        telefon.setKATEGORI_ISMI("Telefon");
        telefon.setKATEGORI_STOK(300);
        telefon.setUst_kategori(elektronik); // Elektronik kategorisi alt kategorisi

        Kategori bilgisayar = new Kategori();
        bilgisayar.setKATEGORI_ISMI("Bilgisayar");
        bilgisayar.setKATEGORI_STOK(200);
        bilgisayar.setUst_kategori(elektronik); // Elektronik kategorisi alt kategorisi

        // Alt kategoriler - Giyim kategorisi altındaki kategoriler
        Kategori tshirt = new Kategori();
        tshirt.setKATEGORI_ISMI("T-shirt");
        tshirt.setKATEGORI_STOK(100);
        tshirt.setUst_kategori(giyim); // Giyim kategorisi alt kategorisi

        Kategori pantolon = new Kategori();
        pantolon.setKATEGORI_ISMI("Pantolon");
        pantolon.setKATEGORI_STOK(150);
        pantolon.setUst_kategori(giyim); // Giyim kategorisi alt kategorisi

        // Alt kategoriler - Oyuncak kategorisi altındaki kategoriler
        Kategori lego = new Kategori();
        lego.setKATEGORI_ISMI("Lego");
        lego.setKATEGORI_STOK(80);
        lego.setUst_kategori(oyuncak); // Oyuncak kategorisi alt kategorisi

        Kategori pelus = new Kategori();
        pelus.setKATEGORI_ISMI("Peluş");
        pelus.setKATEGORI_STOK(120);
        pelus.setUst_kategori(oyuncak); // Oyuncak kategorisi alt kategorisi

        // Alt kategoriler - Mobilya kategorisi altındaki kategoriler
        Kategori sehpa = new Kategori();
        sehpa.setKATEGORI_ISMI("Sehpa");
        sehpa.setKATEGORI_STOK(50);
        sehpa.setUst_kategori(mobilya); // Mobilya kategorisi alt kategorisi

        Kategori kanepe = new Kategori();
        kanepe.setKATEGORI_ISMI("Kanepe");
        kanepe.setKATEGORI_STOK(75);
        kanepe.setUst_kategori(mobilya); // Mobilya kategorisi alt kategorisi

        // Alt kategoriler - Ayakkabı kategorisi altındaki kategoriler
        Kategori bot = new Kategori();
        bot.setKATEGORI_ISMI("Bot");
        bot.setKATEGORI_STOK(50);
        bot.setUst_kategori(ayakkabi); // Ayakkabı kategorisi alt kategorisi

        Kategori sporAyakkabi = new Kategori();
        sporAyakkabi.setKATEGORI_ISMI("Spor Ayakkabı");
        sporAyakkabi.setKATEGORI_STOK(60);
        sporAyakkabi.setUst_kategori(ayakkabi); // Ayakkabı kategorisi alt kategorisi

        // Alt kategoriler - Kitap kategorisi altındaki kategoriler
        Kategori roman = new Kategori();
        roman.setKATEGORI_ISMI("Roman");
        roman.setKATEGORI_STOK(200);
        roman.setUst_kategori(kitap); // Kitap kategorisi alt kategorisi

        Kategori bilimKurgu = new Kategori();
        bilimKurgu.setKATEGORI_ISMI("Bilim Kurgu");
        bilimKurgu.setKATEGORI_STOK(150);
        bilimKurgu.setUst_kategori(kitap); // Kitap kategorisi alt kategorisi

        // Alt kategorileri kaydet
        crudService.Create(Arrays.asList(elektronik, giyim, kitap, ayakkabi, oyuncak, mobilya,telefon, bilgisayar, tshirt, pantolon, lego, pelus, sehpa, kanepe, bot, sporAyakkabi, roman, bilimKurgu));
        System.out.println("kategoriler kaydedildi.");







    }
}
