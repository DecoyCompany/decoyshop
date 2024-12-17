package com.decoyshop.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference("yorum-urun")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "YORUM_YAPILAN_URUN",nullable = false)
    private Urun urun;

    @JsonBackReference("yorum-kullanici")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "YORUMU_YAPAN",nullable = false)
    private Kullanici yorumcu;

    @JoinColumn(name = "YORUMCU_ADI",nullable = false)
    private String yorumcuAdi;

    @Column(name = "PUAN")
    private float puan;

    @Column(name = "YORUM_YAZISI")
    private String yazi;

    @Column(name = "TARIH",nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tarih = new Date();

    @Column(name = "YORUM_RESIMLER")
    private List<String> resimler;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "YORUM_CEVAP")
    private Yorum cevap;

    @Column(name = "SORUMU")
    private boolean sorumu;
}
