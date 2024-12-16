package com.decoyshop.services;

import com.decoyshop.entities.*;
import com.decoyshop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.List;


@Service
public class CRUD_service
{
    private static final Logger logger = LoggerFactory.getLogger(CRUD_service.class);
    private final HashMap<Class<?>, JpaRepository<?, Integer>> repositories = new HashMap<>();
    private final PasswordEncoder passwordEncoder;

    @Autowired
    CRUD_service(PasswordEncoder passwordEncoder, Urun_repo urunRepo, Sirket_repo sirketRepo, Kullanici_repo kullaniciRepo, Kategori_repo kategoriRepo,
                 Yorum_repo yorumRepo, Stock_repo stockRepo, Siparis_repo siparisRepo)
    {
        this.passwordEncoder = passwordEncoder;
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
            if(objeler.getFirst() instanceof Kullanici)
            {
                objeler.forEach(a->
                {
                    String sifre = ((Kullanici)a).getSifre();
                    sifre = passwordEncoder.encode(sifre);
                    ((Kullanici) a).setSifre(sifre);
                });
            }

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

    public boolean Exsist_by_email(String email)
    {
        Kullanici_repo repo =(Kullanici_repo) repositories.get(Kullanici.class);
        Kullanici temp = repo.findByemail(email);
        return temp != null;
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

    public <T> Page<T> Read_more(Class<T> class_type, Pageable page)
    {
        JpaRepository<T, Integer> repo = (JpaRepository<T, Integer>) repositories.get(class_type);
        if (repo != null)
        {
            return repo.findAll(page);
        }
        logger.error("Repository not found for class: {}", class_type.getName());
        return Page.empty();
    }

    public List<Urun> Read_most_popular(Pageable page)
    {
        Urun_repo repo = (Urun_repo) repositories.get(Urun.class);
        if (repo != null)
        {
            return repo.findByOrderByUrunPuaniDesc(page).getContent();
        }
        logger.error("Repository not found for class: {}", Urun.class.getName());
        return List.of();
    }

    public <T> List<T> Read_filtered(Example<T> filter_object)
    {
        JpaRepository<T, Integer> repo = (JpaRepository<T, Integer>) repositories.get(filter_object.getProbeType());
        if (repo != null)
        {
            return repo.findAll(filter_object);
        }
        logger.error("Repository not found for class: {}",filter_object.getProbeType().getName());
        return null;
    }

    public List<Kategori> Read_ust_kategori()
    {
        Kategori_repo repo = (Kategori_repo) repositories.get(Kategori.class);
        if (repo != null)
        {
            return repo.findByustKategoriIsNull();
        }
        logger.error("Repository not found for class: {}",Kategori.class.getName());
        return null;
    }

    public List<Urun> Read_Urun_by_Kategori(List<Integer> kategori_ids)
    {
        if(kategori_ids == null || kategori_ids.isEmpty())
        {
            logger.warn("empty list received!! take a look");
            return null;
        }
        Urun_repo repo = (Urun_repo) repositories.get(Urun.class);
        if (repo != null)
        {
            return repo.findByurunKategorisi_IdIn(kategori_ids);
        }
        logger.error("Repository not found for class: {}", Kategori.class.getName());
        return null;
    }

    public <T> boolean Exists_by_id(Class<T> class_type, List<Integer> ids)
    {
        if(ids == null || ids.isEmpty())
        {
            logger.warn("empty list received!! take a look");
            return false;
        }

        JpaRepository<T, Integer> repo = (JpaRepository<T, Integer>) repositories.get(class_type);
        if (repo != null)
        {
            for (Integer a : ids)
            {
                if(!repo.existsById(a)){return false;}
            }
            return true;
        }
        logger.error("Repository not found for class: {}", class_type.getName());
        return false;
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
                return false;
            }
            repo.deleteAllByIdInBatch(ids);

            if (repo.findAllById(ids).isEmpty())
            {
                logger.warn("Deleted all the {} objects with provided IDs: {}", class_type,ids);
                return true;
            }
            logger.warn("cant delete the all objcets,look class:{} ids:{}", class_type,ids);
            return false;
        }
        logger.error("Repository not found for class: {}", class_type.getName());
        return false;
    }
}
