package com.decoyshop.entities.weak;
import com.decoyshop.entities.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Yorum
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "YORUM_YAPILAN_URUN",nullable = false)
    private Urun urun;

    @ManyToOne
    @JoinColumn(name = "YORUMU_YAPAN",nullable = false)
    private Kullanici yorumcu;

    @Column(name = "PUAN")
    private float puan;

    @Column(name = "YORUM_YAZISI")
    private String yazi;

    @Column(name = "TARIH",nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tarih = new Date();

    @Column(name = "YORUM_RESIMLER")
    private List<String> resimler;

    @OneToOne
    @JoinColumn(name = "YORUM_CEVAP")
    private Yorum cevap;

    @Column(name = "SORUMU")
    private boolean sorumu;
}
