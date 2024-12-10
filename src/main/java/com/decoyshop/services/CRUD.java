package com.decoyshop.services;

import com.decoyshop.entities.*;
import com.decoyshop.entities.weak.*;
import com.decoyshop.repositories.*;
import com.decoyshop.repositories.weak.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class CRUD
{
    private HashMap<Class<?>, JpaRepository<?, Integer>> repositories = new HashMap<>();
    CRUD(Urun_repo urunRepo, Sirket_repo sirketRepo, Kullanici_repo kullaniciRepo, Kategori_repo kategoriRepo,
            Yorum_repo yorumRepo, Stock_repo stockRepo,Siparis_repo siparisRepo)
    {
        repositories.put(Urun.class,urunRepo);
        repositories.put(Sirket.class,sirketRepo);
        repositories.put(Kullanici.class, kullaniciRepo);
        repositories.put(Kategori.class,kategoriRepo);
        repositories.put(Yorum.class,yorumRepo);
        repositories.put(Stock.class,stockRepo);
        repositories.put(Siparis.class,siparisRepo);
    }

    public <T> boolean Create(T obje)
    {
        JpaRepository<T, Integer> repo = (JpaRepository<T, Integer>) repositories.get(obje.getClass());
        if (repo != null)
        {
            repo.save(obje);
            return true;
        }
        return false;
    }
}
