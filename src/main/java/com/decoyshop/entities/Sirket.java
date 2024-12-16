package com.decoyshop.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Sirket extends base_entity
{

    @Column(name = "SIRKET_ISMI", nullable = false)
    private String SIRKET_ISMI;


    @Column(name = "SIRKET_ADRESI")
    private String SIRKET_ADRESI;

    @Column(name = "ILETISIM_NO")
    private String ILETISIM_NO;

    @JsonManagedReference("sirket-siparis")
    @OneToMany(mappedBy = "sirket", cascade = CascadeType.MERGE)
    private List<Siparis> siparisler;

    @JsonManagedReference("sirket-stock")
    @OneToMany(mappedBy = "sirket", cascade = CascadeType.MERGE)
    private List<Stock> stocklar;

}
