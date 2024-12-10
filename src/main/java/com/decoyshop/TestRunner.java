package com.decoyshop;

import com.decoyshop.entities.Kategori;
import com.decoyshop.services.CRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {

    private final CRUD crud;

    @Autowired
    public TestRunner(CRUD crud) {
        this.crud = crud;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create a test instance of 'Urun'
        Kategori testKategori = new Kategori();
        testKategori.setKATEGORI_ISMI("deneme kategori");

        // Call createEntity to save the object
        System.out.println(crud.Create(testKategori));

        System.out.println("Test product has been created and saved.");
    }
}
