package com.decoyshop.entities;
import com.decoyshop.entities.weak.Stock;
import com.decoyshop.entities.weak.Yorum;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
public class Urun
{
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "URUNID")
    private int id;

    @Column(name = "URUN_AD", nullable = false)
    private String URUN_AD;

    @Column(name = "URUN_PUANI", nullable = false)
    private float URUN_PUANI;

    @ElementCollection
    @CollectionTable(name = "URUN_ETIKETLER", joinColumns = @JoinColumn(name = "URUN_ID"))
    @Column(name = "URUN_ETIKETLERI")
    private Collection<String> etiketler;

    @ElementCollection
    @CollectionTable(name = "URUN_RESIMLER", joinColumns = @JoinColumn(name = "URUN_ID"))
    @Column(name = "URUN_RESIMLERI")
    private Collection<String> resimler;

    @ManyToOne
    @JoinColumn(name = "URUN_KATEGORISI",nullable = false )
    private Kategori URUN_KATEGORISI;

    @OneToMany(mappedBy = "urun", cascade = CascadeType.ALL)
    private Collection<Yorum> yorumlar;

    @ManyToMany
    @JoinTable(name = "ONERILER",
            joinColumns = @JoinColumn(name = "URUN_ID"),
            inverseJoinColumns = @JoinColumn(name = "ONERI_URUN_ID"))
    private Collection<Urun> oneriler;

    @OneToMany(mappedBy = "urun",cascade = CascadeType.ALL)
    private Collection<Stock> stoklar;

    @ManyToMany(mappedBy = "favoriler")
    private Collection<Kullanici> favoriOlanKullanicilar;
}
