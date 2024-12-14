package com.decoyshop.entities;

import com.decoyshop.entities.weak.Siparis;
import com.decoyshop.entities.weak.Yorum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Kullanici extends base_entity
{

    @Column(name = "KULLANICI_ADI",nullable = false)
    private String kullanici_adi;

    @Column(name = "KULLANICI_EMAIL",nullable = false)
    private String email;

    @Column(name = "KULLANICI_SIFRE",nullable = false)
    private String sifre;

    @ElementCollection
    @CollectionTable(name = "KULLANICI_KARTLAR", joinColumns = @JoinColumn(name = "KULLANICI_ID"))
    @Column(name = "KULLANICI_KARTLARI",nullable = false)
    private List<String> kart_bilgisi;

    @ElementCollection
    @CollectionTable(name = "KULLANICI_ADRESLER", joinColumns = @JoinColumn(name = "KULLANICI_ID"))
    @Column(name = "KULLANICI_ADRESLERI",nullable = false)
    private List<String> adres_bilgisi;

    @OneToMany(mappedBy = "alici")
    private List<Siparis> siparisler;

    @OneToMany(mappedBy = "yorumcu",cascade = CascadeType.PERSIST)
    private List<Yorum> yorumlar;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "KULLANICI_FAVORILER",
            joinColumns = @JoinColumn(name = "KULLANICI_ID"),
            inverseJoinColumns = @JoinColumn(name = "URUN_ID"))
    private List<Urun> favoriler;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "KULLANICI_SEPET",
            joinColumns = @JoinColumn(name = "KULLANICI_ID"),
            inverseJoinColumns = @JoinColumn(name = "URUN_ID"))
    private List<Urun> sepet;
}
