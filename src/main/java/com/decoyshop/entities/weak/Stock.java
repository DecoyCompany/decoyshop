package com.decoyshop.entities.weak;
import com.decoyshop.entities.Sirket;
import com.decoyshop.entities.Urun;
import com.decoyshop.entities.base_entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Stock extends base_entity
{

    @ManyToOne
    @JoinColumn(name = "SIRKET_ID",nullable = false)
    private Sirket sirket;

    @ManyToOne
    @JoinColumn(name = "URUN_ID",nullable = false)
    private Urun urun;

    @Column(name = "URUN_ACIKLAMA")
    private String aciklama;

    @Column(name = "STOK",nullable = false)
    private int stok;

    @Column(name = "FIYAT",nullable = false)
    private Float fiyat;

    @Column(name = "INDIRIM_ORANI")
    private Float indirim_orani;
}
