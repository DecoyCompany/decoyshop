package com.decoyshop.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class urun
{
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "URUNID")
    private int id;

    @Column(name = "URUN_AD", nullable = false)
    private String URUN_AD;

    @Column(name = "URUN_FIYAT",nullable = false)
    private double URUN_FIYAT;

    @Column(name = "URUN_PUANI", nullable = false)
    private float URUN_PUANI;

    @Column(name = "URUN_ETIKETI", nullable = true)
    private String URUN_ETIKETI;

    @Column(name = "URUN_RESMI" , nullable = true)
    private String URUN_RESMI;

    @Column(name = "URUN_KATEGORISI", nullable = false)
    private String URUN_KATEGORISI;

}
