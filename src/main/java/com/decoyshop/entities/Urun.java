package com.decoyshop.entities;
import com.decoyshop.entities.weak.Stock;
import com.decoyshop.entities.weak.Yorum;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Urun extends base_entity
{

    @Column(name = "URUN_AD", nullable = false)
    private String URUN_AD;

    @Column(name = "URUN_PUANI", nullable = false)
    private float URUN_PUANI;

    @ElementCollection
    @CollectionTable(name = "URUN_ETIKETLER", joinColumns = @JoinColumn(name = "URUN_ID"))
    @Column(name = "URUN_ETIKETLERI")
    private List<String> etiketler;

    @ElementCollection
    @CollectionTable(name = "URUN_RESIMLER", joinColumns = @JoinColumn(name = "URUN_ID"))
    @Column(name = "URUN_RESIMLERI")
    private List<String> resimler;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "URUN_KATEGORISI",nullable = false )
    private Kategori urunKategorisi;

    @OneToMany(mappedBy = "urun", cascade = CascadeType.PERSIST)
    private List<Yorum> yorumlar;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ONERILER",
            joinColumns = @JoinColumn(name = "URUN_ID"),
            inverseJoinColumns = @JoinColumn(name = "ONERI_URUN_ID"))
    private List<Urun> oneriler;

    @OneToMany(mappedBy = "urun",cascade = CascadeType.PERSIST)
    private List<Stock> stoklar;

    @ManyToMany(mappedBy = "favoriler", cascade = CascadeType.PERSIST)
    private List<Kullanici> favoriOlanKullanicilar;
}
