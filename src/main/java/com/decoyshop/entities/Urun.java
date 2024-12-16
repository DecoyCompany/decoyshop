package com.decoyshop.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private float urunPuani;

    @ElementCollection
    @CollectionTable(name = "URUN_ETIKETLER", joinColumns = @JoinColumn(name = "URUN_ID"))
    @Column(name = "URUN_ETIKETLERI")
    private List<String> etiketler;

    @ElementCollection
    @CollectionTable(name = "URUN_RESIMLER", joinColumns = @JoinColumn(name = "URUN_ID"))
    @Column(name = "URUN_RESIMLERI")
    private List<String> resimler;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "URUN_KATEGORISI",nullable = false )
    private Kategori urunKategorisi;

    @JsonManagedReference("yorum-urun")
    @OneToMany(mappedBy = "urun", cascade = CascadeType.MERGE)
    private List<Yorum> yorumlar;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "ONERILER",
            joinColumns = @JoinColumn(name = "URUN_ID"),
            inverseJoinColumns = @JoinColumn(name = "ONERI_URUN_ID"))
    private List<Urun> oneriler;

    @JsonManagedReference("urun-stock")
    @OneToMany(mappedBy = "urun",cascade = CascadeType.MERGE)
    private List<Stock> stoklar;
}
