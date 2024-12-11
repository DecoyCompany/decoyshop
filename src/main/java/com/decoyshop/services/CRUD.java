package com.decoyshop.services;

import com.decoyshop.entities.*;
import com.decoyshop.entities.weak.*;
import com.decoyshop.repositories.*;
import com.decoyshop.repositories.weak.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.List;


@Service
public class CRUD
{
    private static final Logger logger = LoggerFactory.getLogger(CRUD.class);

    private final HashMap<Class<?>, JpaRepository<?, Integer>> repositories = new HashMap<>();
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

    public <T> boolean Create(List<T> objeler)
    {
        if(objeler == null || objeler.isEmpty())
        {
            logger.warn("empty list received!! take a look");
            return false;
        }
        JpaRepository<T, Integer> repo = (JpaRepository<T, Integer>) repositories.get(objeler.getFirst().getClass());
        if (repo != null)
        {
            repo.saveAllAndFlush(objeler);
            return true;
        }
        logger.error("Repository not found for class: {}", objeler.getFirst().getClass().getName());
        return false;
    }

    public <T> List<T> Read_by_id(Class<T> class_type, List<Integer> ids)
    {
        if(ids == null || ids.isEmpty())
        {
            logger.warn("empty list received!! take a look");
            return null;
        }

        JpaRepository<T, Integer> repo = (JpaRepository<T, Integer>) repositories.get(class_type);
        if (repo != null)
        {
            return repo.findAllById(ids);
        }
        logger.error("Repository not found for class: {}", class_type.getName());
        return null;
    }

    public <T> List<T> Read_more(Class<T> class_type)
    {
        JpaRepository<T, Integer> repo = (JpaRepository<T, Integer>) repositories.get(class_type);
        if (repo != null)
        {
            return repo.findAll();
        }
        logger.error("Repository not found for class: {}", class_type.getName());
        return null;
    }

    public <T> Page Read_more(Class<T> class_type, Pageable page)
    {
        JpaRepository<T, Integer> repo = (JpaRepository<T, Integer>) repositories.get(class_type);
        if (repo != null)
        {
            return repo.findAll(page);
        }
        logger.error("Repository not found for class: {}", class_type.getName());
        return Page.empty();
    }

    public <T> boolean Update(List<T> objeler)
    {
        return Create(objeler);
    }

    public <T> boolean Delete_by_id(Class<T> class_type, List<Integer> ids)
    {
        if(ids == null || ids.isEmpty())
        {
            logger.warn("empty list received!! take a look");
            return false;
        }

        JpaRepository<T, Integer> repo = (JpaRepository<T, Integer>) repositories.get(class_type);
        if (repo != null)
        {
            if (repo.findAllById(ids).isEmpty())
            {
                logger.warn("No entities found for deletion with provided IDs: {}", ids);
            }
            return true;
        }
        logger.error("Repository not found for class: {}", class_type.getName());
        return false;
    }
}
