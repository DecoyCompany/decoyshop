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
        Kategori testKategori = new Kategori();
        testKategori.setKATEGORI_ISMI("deneme kategori");

        Kategori testKategori2 = new Kategori();
        testKategori2.setKATEGORI_ISMI("deneme kategori2");

        ArrayList<Kategori> kategoris = new ArrayList<>(5);
        kategoris.add(testKategori);
        kategoris.add(testKategori2);

        Kategori testKategori3 = new Kategori();
        testKategori3.setKATEGORI_ISMI("deneme kategori3");

        testKategori3.setAlt_kategoriler((List<Kategori>) kategoris.clone());

        testKategori.setUst_kategori(testKategori3);
        testKategori2.setUst_kategori(testKategori3);

        kategoris.add(testKategori3);

        // Call createEntity to save the object
        System.out.println(crudService.Create(kategoris));

        List<Kategori> dondu = new ArrayList<>(5);
        dondu = (List<Kategori>) crudService.Read_more(testKategori.getClass());

        dondu.forEach(a->{
            System.out.println(a.getKATEGORI_ISMI());
        });

        System.out.println("Test products has been created, saved and retrived.");

        testKategori3.setKATEGORI_ISMI("dehistrilmis isim");
        testKategori2.setKATEGORI_ISMI("birazdan silenecek obje");

        kategoris.clear();
        kategoris.add(testKategori3);

        System.out.println(crudService.Update(kategoris));

        dondu = (List<Kategori>) crudService.Read_more(testKategori.getClass());

        dondu.forEach(a->{
            System.out.println(a.getKATEGORI_ISMI());
        });

        System.out.println( crudService.Delete_by_id(testKategori2.getClass(),Arrays.asList(testKategori2.getId())));

        dondu = (List<Kategori>) crudService.Read_more(testKategori.getClass());

        dondu.forEach(a->{
            System.out.println(a.getKATEGORI_ISMI());
        });
    }
}
