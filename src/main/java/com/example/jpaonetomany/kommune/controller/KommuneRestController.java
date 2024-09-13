package com.example.jpaonetomany.kommune.controller;

import com.example.jpaonetomany.kommune.model.KommuneModel;
import com.example.jpaonetomany.kommune.repository.KommuneRepository;
import com.example.jpaonetomany.kommune.service.ApiServiceGetKommuner;
import com.example.jpaonetomany.region.model.RegionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class KommuneRestController {

    @Autowired
    ApiServiceGetKommuner apiServiceGetKommuner;
    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("/getKommuner")
    public List<KommuneModel> getKommuner() {
        List<KommuneModel> listKommune = apiServiceGetKommuner.getKommuner();
        return listKommune;
    }

    @PostMapping("/createKommune")
    @ResponseStatus(HttpStatus.CREATED)
    public KommuneModel createKommune(@RequestBody KommuneModel kommuneModel) {
        System.out.println(kommuneModel);

        return kommuneRepository.save(kommuneModel);
    }

    @DeleteMapping("/deleteKommune/{deleteKode}")
    public ResponseEntity<Void> deleteKommune(@PathVariable int deleteKode) {
        Optional<KommuneModel> orgKommune = kommuneRepository.findById(deleteKode);
        if(orgKommune.isPresent()) {
            kommuneRepository.deleteById(deleteKode);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
