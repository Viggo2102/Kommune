package com.example.jpaonetomany.region.model;

import com.example.jpaonetomany.kommune.model.KommuneModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.HashSet;
import java.util.Set;

@Entity
public class RegionModel {
    @Id
    @Column(length = 4)
    private String kode;
    private String navn;
    private String href;

    @OneToMany(mappedBy = "regionModel")
    @JsonBackReference
    private Set<KommuneModel> kommuner = new HashSet<>();

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

    public Set<KommuneModel> getKommuner() {
        return kommuner;
    }

    public void setKommuner(Set<KommuneModel> kommuner) {
        this.kommuner = kommuner;
    }
}
