package com.example.jpaonetomany.kommune.model;

import com.example.jpaonetomany.region.model.RegionModel;
import jakarta.persistence.*;

@Entity
public class KommuneModel {

    @Id
    @Column(length = 4)
    private String kode;
    private String navn;
    private String href;

    @ManyToOne
    @JoinColumn(name ="regionModel", referencedColumnName = "kode")

    RegionModel regionModel;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public RegionModel getRegionModel() {
        return regionModel;
    }

    public void setRegionModel(RegionModel regionModel) {
        this.regionModel = regionModel;
    }
}
