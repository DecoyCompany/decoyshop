package com.decoyshop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Stock extends base_entity
{
    @JsonBackReference("sirket-stock")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "SIRKET_ID",nullable = false)
    private Sirket sirket;

    @JsonBackReference("urun-stock")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "URUN_ID",nullable = false)
    private Urun urun;

    @Column(name = "URUN_ACIKLAMA")
    private String aciklama;

    @Column(name = "STOK",nullable = false)
    private int stok = 0;

    @Column(name = "FIYAT",nullable = false)
    private Float fiyat = 0.0F;

    @Column(name = "INDIRIM_ORANI", nullable = false)
    private Float indirim_orani = 1F;
}
