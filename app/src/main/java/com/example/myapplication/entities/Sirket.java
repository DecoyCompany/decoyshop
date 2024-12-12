package com.example.myapplication.entities;


import jakarta.persistence.*;
import lombok.Data;
import com.decoyshop.entities.weak.Stock;
import com.decoyshop.entities.weak.Siparis;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Sirket extends base_entity
{

    @Column(name = "SIRKET_ISMI", nullable = false)
    private String SIRKET_ISMI;


    @Column(name = "SIRKET_ADRESI", nullable = false)
    private String SIRKET_ADRESI;

    @Column(name = "ILETISIM_NO", nullable = false)
    private String ILETISIM_NO;

    @OneToMany(mappedBy = "sirket", cascade = CascadeType.ALL)
    private List<Siparis> siparisler;

    @OneToMany(mappedBy = "sirket", cascade = CascadeType.ALL)
    private List<Stock> stocklar;

}
