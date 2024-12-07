package com.decoyshop.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class urun
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String isim;
}
