package com.decoyshop.entities.weak;
import com.decoyshop.entities.*;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Siparis extends base_entity
{
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
