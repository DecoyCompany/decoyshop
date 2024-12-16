package com.decoyshop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Siparis extends base_entity
{
    @JsonBackReference("sirket-siparis")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "SIRKET_ID",nullable = false)
    private Sirket sirket;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "SIPARIS_URUN",
            joinColumns = @JoinColumn(name = "SIPARIS_ID"),
            inverseJoinColumns = @JoinColumn(name = "URUN_ID"))
    private List<Urun> alinan_urunler;

    @JsonBackReference("siparis-kullanıcı")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ALICI",nullable = false)
    private Kullanici alici;

    @Column(name = "SIPARIS_DETAY")
    private String siparisDetay;

    @Column(name = "TAMAMLANDIMI")
    private boolean tamamlandimi = false;
}
