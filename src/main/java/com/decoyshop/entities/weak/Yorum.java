package com.decoyshop.entities.weak;
import com.decoyshop.entities.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Yorum extends base_entity
{

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "YORUM_YAPILAN_URUN",nullable = false)
    private Urun urun;

    @ManyToOne(cascade = CascadeType.PERSIST)
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

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "YORUM_CEVAP")
    private Yorum cevap;

    @Column(name = "SORUMU")
    private boolean sorumu;
}
