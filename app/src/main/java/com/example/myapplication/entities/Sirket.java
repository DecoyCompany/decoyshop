package com.example.myapplication.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;


import java.util.List;

public class Sirket extends base_entity
{

    private String SIRKET_ISMI;

    private String SIRKET_ADRESI;

    private String ILETISIM_NO;

    @JsonManagedReference("sirket-siparis")
    private List<Siparis> siparisler;

    @JsonManagedReference("sirket-stock")
    private List<Stock> stocklar;

    public String getSIRKET_ISMI() {
        return SIRKET_ISMI;
    }

    public void setSIRKET_ISMI(String SIRKET_ISMI) {
        this.SIRKET_ISMI = SIRKET_ISMI;
    }

    public String getSIRKET_ADRESI() {
        return SIRKET_ADRESI;
    }

    public void setSIRKET_ADRESI(String SIRKET_ADRESI) {
        this.SIRKET_ADRESI = SIRKET_ADRESI;
    }

    public String getILETISIM_NO() {
        return ILETISIM_NO;
    }

    public void setILETISIM_NO(String ILETISIM_NO) {
        this.ILETISIM_NO = ILETISIM_NO;
    }

    public List<Siparis> getSiparisler() {
        return siparisler;
    }

    public void setSiparisler(List<Siparis> siparisler) {
        this.siparisler = siparisler;
    }

    public List<Stock> getStocklar() {
        return stocklar;
    }

    public void setStocklar(List<Stock> stocklar) {
        this.stocklar = stocklar;
    }
}
