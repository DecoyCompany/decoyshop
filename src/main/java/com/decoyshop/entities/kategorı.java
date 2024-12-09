package com.decoyshop.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class kategorı {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KATEGORI_ID",nullable = false)
    private int id;

    @Column(name = "KATEGORI_ISMI", nullable = false)
    private String KATEGORI_ISMI;

    @Column(name = "KATEGORI_STOK",nullable = false)
    private int KATEGORI_STOK;


}
