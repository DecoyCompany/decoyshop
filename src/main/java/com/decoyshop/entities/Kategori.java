package com.decoyshop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Kategori extends base_entity
{

    @Column(name = "KATEGORI_ISMI", nullable = false)
    private String KATEGORI_ISMI;

    @Column(name = "KATEGORI_STOK",nullable = false)
    private int KATEGORI_STOK = 0;

    @JsonBackReference("alt-ust_kategori")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "UST_KATEGORI_ID")
    private Kategori ust_kategori;

    @JsonManagedReference("alt-ust_kategori")
    @OneToMany(mappedBy = "ust_kategori", cascade = CascadeType.MERGE)
    private List<Kategori> alt_kategoriler;
}
