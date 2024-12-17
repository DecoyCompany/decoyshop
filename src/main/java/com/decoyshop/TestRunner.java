package com.decoyshop;

import com.decoyshop.entities.*;
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
//        // Create a test instance of 'Urun'
//        // Ana kategoriler
//        Kategori elektronik = new Kategori();
//        elektronik.setKATEGORI_ISMI("Elektronik");
//        elektronik.setKATEGORI_STOK(1000);
//        elektronik.setUstKategori(null); // Ana kategori, ust_kategori_id null
//
//        Kategori giyim = new Kategori();
//        giyim.setKATEGORI_ISMI("Giyim");
//        giyim.setKATEGORI_STOK(500);
//        giyim.setUstKategori(null); // Ana kategori, ust_kategori_id null
//
//
//        Kategori oyuncak = new Kategori();
//        oyuncak.setKATEGORI_ISMI("Oyuncak");
//        oyuncak.setKATEGORI_STOK(1000);
//        oyuncak.setUstKategori(null); // Ana kategori, ust_kategori_id null
//
//        Kategori mobilya = new Kategori();
//        mobilya.setKATEGORI_ISMI("Mobilya");
//        mobilya.setKATEGORI_STOK(500);
//        mobilya.setUstKategori(null); // Ana kategori, ust_kategori_id null
//
//
//        Kategori ayakkabi = new Kategori();
//        ayakkabi.setKATEGORI_ISMI("Ayakkabı");
//        ayakkabi.setKATEGORI_STOK(450);
//        ayakkabi.setUstKategori(null); // Ana kategori, ust_kategori_id null
//
//        Kategori kitap = new Kategori();
//        kitap.setKATEGORI_ISMI("Kitap");
//        kitap.setKATEGORI_STOK(500);
//        kitap.setUstKategori(null); // Ana kategori, ust_kategori_id null
//
//        // Ana kategorileri kaydet
//        /*
//        crudService.Create(Arrays.asList(elektronik, giyim, kitap, ayakkabi, oyuncak, mobilya));
//        System.out.println("Ana kategoriler kaydedildi.");
//        */
//
//
//        ArrayList<Kategori> kategoris = new ArrayList<>(50);
//        kategoris.add(kitap);
//        kategoris.add(oyuncak);
//        kategoris.add(giyim);
//        kategoris.add(mobilya);
//        kategoris.add(elektronik);
//        kategoris.add(ayakkabi);
//
//
//
//        // Alt kategoriler - Elektronik kategorisi altındaki kategoriler
//        Kategori telefon = new Kategori();
//        telefon.setKATEGORI_ISMI("Telefon");
//        telefon.setKATEGORI_STOK(300);
//        telefon.setUstKategori(elektronik); // Elektronik kategorisi alt kategorisi
//
//        Kategori bilgisayar = new Kategori();
//        bilgisayar.setKATEGORI_ISMI("Bilgisayar");
//        bilgisayar.setKATEGORI_STOK(200);
//        bilgisayar.setUstKategori(elektronik); // Elektronik kategorisi alt kategorisi
//
//        // Alt kategoriler - Giyim kategorisi altındaki kategoriler
//        Kategori tshirt = new Kategori();
//        tshirt.setKATEGORI_ISMI("T-shirt");
//        tshirt.setKATEGORI_STOK(100);
//        tshirt.setUstKategori(giyim); // Giyim kategorisi alt kategorisi
//
//        Kategori pantolon = new Kategori();
//        pantolon.setKATEGORI_ISMI("Pantolon");
//        pantolon.setKATEGORI_STOK(150);
//        pantolon.setUstKategori(giyim); // Giyim kategorisi alt kategorisi
//
//        // Alt kategoriler - Oyuncak kategorisi altındaki kategoriler
//        Kategori lego = new Kategori();
//        lego.setKATEGORI_ISMI("Lego");
//        lego.setKATEGORI_STOK(80);
//        lego.setUstKategori(oyuncak); // Oyuncak kategorisi alt kategorisi
//
//        Kategori pelus = new Kategori();
//        pelus.setKATEGORI_ISMI("Peluş");
//        pelus.setKATEGORI_STOK(120);
//        pelus.setUstKategori(oyuncak); // Oyuncak kategorisi alt kategorisi
//
//        // Alt kategoriler - Mobilya kategorisi altındaki kategoriler
//        Kategori sehpa = new Kategori();
//        sehpa.setKATEGORI_ISMI("Sehpa");
//        sehpa.setKATEGORI_STOK(50);
//        sehpa.setUstKategori(mobilya); // Mobilya kategorisi alt kategorisi
//
//        Kategori kanepe = new Kategori();
//        kanepe.setKATEGORI_ISMI("Kanepe");
//        kanepe.setKATEGORI_STOK(75);
//        kanepe.setUstKategori(mobilya); // Mobilya kategorisi alt kategorisi
//
//        // Alt kategoriler - Ayakkabı kategorisi altındaki kategoriler
//        Kategori bot = new Kategori();
//        bot.setKATEGORI_ISMI("Bot");
//        bot.setKATEGORI_STOK(50);
//        bot.setUstKategori(ayakkabi); // Ayakkabı kategorisi alt kategorisi
//
//        Kategori sporAyakkabi = new Kategori();
//        sporAyakkabi.setKATEGORI_ISMI("Spor Ayakkabı");
//        sporAyakkabi.setKATEGORI_STOK(60);
//        sporAyakkabi.setUstKategori(ayakkabi); // Ayakkabı kategorisi alt kategorisi
//
//        // Alt kategoriler - Kitap kategorisi altındaki kategoriler
//        Kategori roman = new Kategori();
//        roman.setKATEGORI_ISMI("Roman");
//        roman.setKATEGORI_STOK(200);
//        roman.setUstKategori(kitap); // Kitap kategorisi alt kategorisi
//
//        Kategori bilimKurgu = new Kategori();
//        bilimKurgu.setKATEGORI_ISMI("Bilim Kurgu");
//        bilimKurgu.setKATEGORI_STOK(150);
//        bilimKurgu.setUstKategori(kitap); // Kitap kategorisi alt kategorisi
//
//        // Alt kategorileri kaydet
//        crudService.Create(Arrays.asList(elektronik, giyim, kitap, ayakkabi, oyuncak, mobilya,telefon, bilgisayar, tshirt, pantolon, lego, pelus, sehpa, kanepe, bot, sporAyakkabi, roman, bilimKurgu));
//        System.out.println("kategoriler kaydedildi.");

        Kullanici altay = new Kullanici();
        altay.setEmail("altay@gmail.com");
        altay.setKullanici_adi("altay gök");
        altay.setSifre("altay123");

        crudService.Create(List.of(altay));

        Kategori bitki = new Kategori();
        bitki.setKATEGORI_ISMI("bitkiler");
        bitki.setKATEGORI_STOK(150);

        crudService.Create(List.of(bitki));

        Kategori agac = new Kategori();
        agac.setKATEGORI_ISMI("Ağaç");
        agac.setKATEGORI_STOK(150);
        agac.setUstKategori(bitki);

        crudService.Create(List.of(agac));

        Urun ceviz_agaci =new Urun();
        ceviz_agaci.setURUN_AD("ceviz ağacı");
        ceviz_agaci.setUrunKategorisi(agac);
        ceviz_agaci.setResimler(List.of("/pictures/ceviz_agaci.png","/pictures/ceviz_agaci2.png"));
        ceviz_agaci.setUrunPuani(9.7F);

        crudService.Create(List.of(ceviz_agaci));

        Yorum ceviz_agaci_yorum = new Yorum();
        ceviz_agaci_yorum.setUrun(ceviz_agaci);
        ceviz_agaci_yorum.setPuan(6.7F);
        ceviz_agaci_yorum.setYazi("ben bir ceviz ağacıyım gülhane parkında\n" +
                "ne sen farkındasın ne de polis farkında");
        ceviz_agaci_yorum.setYorumcu(altay);
        ceviz_agaci_yorum.setYorumcuAdi(altay.getKullanici_adi());

        crudService.Create(List.of(ceviz_agaci_yorum));

        // xxxxx
        Urun cam_agaci =new Urun();
        cam_agaci.setURUN_AD("cam agaci");
        cam_agaci.setUrunKategorisi(agac);
        cam_agaci.setResimler(Arrays.asList("/pictures/cam_agaci.png"));

        crudService.Create(List.of(cam_agaci));

        Urun mese_agaci =new Urun();
        mese_agaci.setURUN_AD("mese agaci");
        mese_agaci.setUrunKategorisi(agac);
        mese_agaci.setResimler(List.of("/pictures/mese_agaci.png"));

        crudService.Create(List.of(mese_agaci));

        Sirket cem_karaca = new Sirket();
        cem_karaca.setSIRKET_ISMI("cem_karaca");

        crudService.Create(List.of(cem_karaca));

        Stock stock = new Stock();
        stock.setUrun(new Urun().setId(ceviz_agaci.getId()));
        stock.setStok(500);
        stock.setSirket(new Sirket().setId(cem_karaca.getId()));
        stock.setFiyat(10F);
        stock.setIndirim_orani(1F);
        stock.setAciklama("bu ceviz ağacı gülhane parkında değildir!\n" +
                "lütfen artık sormayın. yılda 3kg ceviz verir.");

        //xxxxxxxxxxx
        Stock stock2 = new Stock();
        stock2.setUrun(new Urun().setId(cam_agaci.getId()));
        stock2.setStok(500);
        stock2.setSirket(new Sirket().setId(cem_karaca.getId()));
        stock2.setFiyat(10F);
        stock2.setIndirim_orani(1F);

        //xxxxxxxxxxxxxx
        Stock stock3 = new Stock();
        stock3.setUrun(new Urun().setId(mese_agaci.getId()));
        stock3.setStok(500);
        stock3.setSirket(new Sirket().setId(cem_karaca.getId()));
        stock3.setFiyat(10F);
        stock3.setIndirim_orani(1F);

        crudService.Create(List.of(stock,stock2,stock3));

    }
}
