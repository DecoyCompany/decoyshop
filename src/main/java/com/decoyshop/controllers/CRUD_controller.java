package com.decoyshop.controllers;

import com.decoyshop.entities.*;
import com.decoyshop.services.CRUD_service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/CRUD")
public class CRUD_controller
{
    private static final Logger logger = LoggerFactory.getLogger(CRUD_controller.class);

    @Autowired
    private CRUD_service crud;

    @PostMapping(value = "/create")
    public <T extends base_entity> ResponseEntity<String> Create(@RequestBody List<T> objeler)
    {
        if(objeler == null || objeler.isEmpty())
        {
            logger.warn("empty list received!! take a look");
            return ResponseEntity.status(400).body("you sent a null or empty list!!!");
        }
        boolean value = crud.Create(objeler);

        return value ? ResponseEntity.ok("objects created") : ResponseEntity.status(500).body("Something go wrong");
    }

    @GetMapping(value = "/read/{class}/all")
    public <T extends base_entity> ResponseEntity<List<T>> Read_all(@PathVariable("class") String class_type_string)
    {
        try
        {
            Class<T> class_type = (Class<T>) Class.forName("com.decoyshop.entities." + class_type_string);
            List<T> value = crud.Read_more(class_type);
            if(value == null || value.isEmpty())
            {
                return ResponseEntity.status(500).body(null);
            }
            return ResponseEntity.ok(value);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping(value = "/read/{class}/{batch_size}/{batch_number}")
    public <T extends base_entity> ResponseEntity<List<T>> Read_batch(@PathVariable("class") String class_type_string,
                                            @PathVariable("batch_size") int batch_size, @PathVariable("batch_number") int batch_number)
    {
        try
        {
            Class<T> class_type = (Class<T>) Class.forName("com.decoyshop.entities." + class_type_string);

            if(batch_size<1 || batch_number<0)
            {
                return ResponseEntity.status(400).body(null);
            }

            Pageable pageable = PageRequest.of(batch_number,batch_size);

            if(class_type == Urun.class)
            {
                List<Urun> value = crud.Read_most_popular(pageable);

                if(value == null || value.isEmpty())
                {
                    return ResponseEntity.status(500).body(null);
                }
                return ResponseEntity.ok((List<T>) value);
            }

            Page<T> page = crud.Read_more(class_type,pageable);

            if(page == null || page.isEmpty())
            {
                return ResponseEntity.status(500).body(null);
            }
            return ResponseEntity.ok(page.getContent());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping(value = "/read/{class}/by_id/{ids}")
    public <T extends base_entity> ResponseEntity<List<T>> Read_by_id(@PathVariable("class") String class_type_string, @PathVariable("ids") List<Integer> ids)
    {
        try
        {
            Class<T> class_type = (Class<T>) Class.forName("com.decoyshop.entities." + class_type_string);

                if(ids == null || ids.isEmpty())
            {
                logger.warn("empty list received!! take a look");
                return ResponseEntity.status(400).body(null);
            }

            List<T> value = crud.Read_by_id(class_type,ids);
            if(value == null || value.isEmpty())
            {
                return ResponseEntity.status(500).body(null);
            }
            return ResponseEntity.ok(value);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping(value = "/read/urunler/kategori{kategori_ids}")
    public ResponseEntity<List<Urun>> Read_urun_with_kategori(@PathVariable("kategori_ids") List<Integer> kategori_ids)
    {
        if(kategori_ids == null || kategori_ids.isEmpty())
        {
            logger.warn("empty list received!! take a look");
            return ResponseEntity.status(400).body(null);
        }
        if(crud.Exists_by_id(Kategori.class,kategori_ids))
        {
            List<Urun> values = crud.Read_Urun_by_Kategori(kategori_ids);

            if(values == null || values.isEmpty())
            {
                return ResponseEntity.status(500).body(null);
            }

            return ResponseEntity.ok(values);
        }
        return ResponseEntity.status(400).body(null);
    }

    @GetMapping(value = "/read/ust_kategori")
    public ResponseEntity<List<Kategori>> Read_ust_kategori()
    {

        List<Kategori> value = crud.Read_ust_kategori();

        if (value == null || value.isEmpty())
        {
            return ResponseEntity.status(500).body(null);
        }

        return ResponseEntity.ok(value);
    }

    @PutMapping(value = "/update")
    public <T extends base_entity> ResponseEntity<String> Update(@RequestBody List<T> objeler)
    {
        if(objeler == null || objeler.isEmpty())
        {
            logger.warn("empty list received!! take a look");
            return ResponseEntity.status(400).body("you sent a null or empty list!!!");
        }

        List<Integer> ids = new ArrayList<>(objeler.size());
        for(T obje: objeler){ids.add(obje.getId());}

        if(! crud.Exists_by_id(objeler.getFirst().getClass(),ids))
        {
            return ResponseEntity.status(400).body("One or more objects you want to update do not exist!");
        }

        boolean value = crud.Update(objeler);

        return value ? ResponseEntity.ok("objects Updated") : ResponseEntity.status(500).body("Something go wrong");
    }

    @DeleteMapping(name = "/delete/{ids}")
    public <T extends base_entity> ResponseEntity<String> Delete(@RequestBody Class<T> class_type,@PathVariable("ids") List<Integer> ids)
    {
        if(ids == null || ids.isEmpty())
        {
            logger.warn("empty list received!! take a look");
            return ResponseEntity.status(400).body(null);
        }

        if(! crud.Exists_by_id(class_type,ids))
        {
            return ResponseEntity.status(400).body("One or more objects you want to delete do not exist!");
        }

        boolean value = crud.Delete_by_id(class_type,ids);

        return value ? ResponseEntity.ok("objects Deleted") : ResponseEntity.status(500).body("Something go wrong");
    }
}
