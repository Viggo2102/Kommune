package com.example.jpaonetomany.region.service;

import com.example.jpaonetomany.region.model.RegionModel;
import com.example.jpaonetomany.region.repository.RegionRepository;
import org.hibernate.cache.spi.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceGetRegionerImpl implements ApiServiceGetRegioner {

    //Her dependency injekter vi klassen i vores constructor.
    private RestTemplate restTemplate;

    public ApiServiceGetRegionerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    String regionUrl ="https://api.dataforsyningen.dk/regioner";

    @Autowired
    RegionRepository regionRepository;


    private void saveRegioner(List<RegionModel> regioner) {
        regioner.forEach(reg -> regionRepository.save(reg));
    }
    @Override
    public List<RegionModel> getRegioner() {
        List<RegionModel> regionList = new ArrayList<>();
        ResponseEntity<List<RegionModel>> regionResponse = restTemplate.exchange(regionUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<RegionModel>>() {
        });
        List<RegionModel> regioner = regionResponse.getBody();
        saveRegioner(regioner);

        return regioner;

    }

}
