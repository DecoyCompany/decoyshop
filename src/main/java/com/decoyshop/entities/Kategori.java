package com.decoyshop.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Kategori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KATEGORI_ID",nullable = false)
    private int id;

    @Column(name = "KATEGORI_ISMI", nullable = false)
    private String KATEGORI_ISMI;

    @Column(name = "KATEGORI_STOK",nullable = false)
    private int KATEGORI_STOK = 0;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UST_KATEGORI_ID")
    private Kategori ust_kategori;

    @OneToMany(mappedBy = "ust_kategori", cascade = CascadeType.ALL)
    private List<Kategori> alt_kategoriler;
}
