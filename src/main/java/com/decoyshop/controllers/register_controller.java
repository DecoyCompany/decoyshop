package com.decoyshop.controllers;

import com.decoyshop.entities.Kullanici;
import com.decoyshop.services.CRUD_service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;

@RestController
@RequestMapping(value = "/register")
public class register_controller
{
    private static final Logger logger = LoggerFactory.getLogger(register_controller.class);

    @Autowired
    private CRUD_service crud;

   @GetMapping(value = "/email_exsist/{email}")
    private ResponseEntity<Boolean> email_exsist(@PathVariable("email") String email)
   {
       if(email == null)
       {
           logger.warn("received empty mail, take look!");
           return ResponseEntity.badRequest().body(null);
       }
       return ResponseEntity.ok(crud.Exsist_by_email(email));
   }

   @PostMapping(value = "/user")
    private ResponseEntity<String> Create_user(@RequestBody Kullanici kullanici)
   {
       logger.info("Received user registration request: {}", kullanici);

       if(kullanici == null)
       {
           logger.warn("received empty user, take look!");
           return ResponseEntity.badRequest().body("server didn't receive user");
       }
       if(crud.Exsist_by_email(kullanici.getEmail()))
       {
           logger.warn("email already exist");
           return ResponseEntity.status(409).body("Email already exist");
       }
       boolean value =  crud.Create(Arrays.asList(kullanici));
       return value ? ResponseEntity.status(200).body("Register successful") : ResponseEntity.status(500).body("Something go wrong");
   }
}
