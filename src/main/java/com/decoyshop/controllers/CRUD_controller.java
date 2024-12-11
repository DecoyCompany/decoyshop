package com.decoyshop.controllers;

import com.decoyshop.services.CRUD_service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping(value = "/CRUD")
public class CRUD_controller
{
    private static final Logger logger = LoggerFactory.getLogger(CRUD_service.class);

    @Autowired
    private CRUD_service crud;

    @PostMapping(value = "/create")
    public <T> ResponseEntity<String> Create(@RequestBody List<T> objeler)
    {
        if(objeler == null || objeler.isEmpty())
        {
            logger.warn("empty list received!! take a look");
            return ResponseEntity.status(400).body("you sent a null or empty list!!!");
        }
        boolean value = crud.Create(objeler);

        return value ? ResponseEntity.ok("objects created") : ResponseEntity.status(500).body("Something go wrong");
    }

    @GetMapping(value = "/read/all")
    public <T> ResponseEntity<List<T>> Read(@RequestBody Class<T> class_type)
    {
        List<T> value = crud.Read_more(class_type);
        if(value == null || value.isEmpty())
        {
            return ResponseEntity.status(500).body(null);
        }
        return ResponseEntity.ok(value);
    }

    @GetMapping(value = "/read/{batch_size}/{batch_number}")
    public <T> ResponseEntity<List<T>> Read(@RequestBody Class<T> class_type,
                                            @PathVariable("batch_size") int batch_size, @PathVariable("batch_number") int batch_number)
    {
        if(batch_size<1 || batch_number<0)
        {
            return ResponseEntity.status(400).body(null);
        }

        Pageable pageable = PageRequest.of(batch_number,batch_size);
        Page<T> page = crud.Read_more(class_type,pageable);

        if(page == null || page.isEmpty())
        {
            return ResponseEntity.status(500).body(null);
        }
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping(value = "/read/by_id/{ids}")
    public <T> ResponseEntity<List<T>> Read(@RequestBody Class<T> class_type, @PathVariable("ids") List<Integer> ids)
    {
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

}
