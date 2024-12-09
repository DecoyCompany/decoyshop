package com.decoyshop.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class sirket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SIRKET_ID", nullable = false)
    private int SIRKET_ID;

    @Column(name = "SIRKET_ISMI", nullable = false)
    private String SIRKET_ISMI;


    @Column(name = "SIRKET_ADRESI", nullable = false)
    private String SIRKET_ADRESI;

    @Column(name = "ILETISIM_NO", nullable = false)
    private int ILETISIM_NO;


    @Column(name = "ALINAN_SIPARIS_ID", nullable = false)
    private int ALINAN_SIPARIS_ID;

    @Column(name = "STOCK_ID", nullable = false)
    private int STOCK_ID;


}
