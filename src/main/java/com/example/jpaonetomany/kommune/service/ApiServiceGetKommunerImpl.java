package com.example.jpaonetomany.kommune.service;

import com.example.jpaonetomany.kommune.model.KommuneModel;
import com.example.jpaonetomany.kommune.repository.KommuneRepository;
import com.example.jpaonetomany.region.model.RegionModel;
import com.example.jpaonetomany.region.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class ApiServiceGetKommunerImpl implements ApiServiceGetKommuner {
    //Her dependency injekter vi klassen i vores constructor.
    private RestTemplate restTemplate;

    public ApiServiceGetKommunerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    String kommuneUrl ="https://api.dataforsyningen.dk/kommuner";

    @Autowired
    KommuneRepository kommuneRepository;


    private void saveKommuner(List<KommuneModel> kommuner) {
        kommuner.forEach(reg -> kommuneRepository.save(reg));
    }
    @Override
    public List<KommuneModel> getKommuner() {
        ResponseEntity<List<KommuneModel>> kommuneResponse = restTemplate.exchange(kommuneUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<KommuneModel>>() {
        });
        List<KommuneModel> kommuner = kommuneResponse.getBody();
        saveKommuner(kommuner);

        return kommuner;

    }

}

