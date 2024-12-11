package com.decoyshop.entities.weak;
import com.decoyshop.entities.*;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Siparis
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "SIRKET_ID",nullable = false)
    private Sirket sirket;

    @ManyToMany
    @JoinTable(name = "SIPARIS_URUN",
            joinColumns = @JoinColumn(name = "SIPARIS_ID"),
            inverseJoinColumns = @JoinColumn(name = "URUN_ID"))
    private List<Urun> alinan_urunler;

    @ManyToOne
    @JoinColumn(name = "ALICI",nullable = false)
    private Kullanici alici;

    @Column(name = "SIPARIS_DETAY")
    private String siparisDetay;

    @Column(name = "TAMAMLANDIMI")
    private boolean tamamlandimi;
}
