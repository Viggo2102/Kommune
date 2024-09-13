package com.example.jpaonetomany.region.controller;

import com.example.jpaonetomany.region.model.RegionModel;
import com.example.jpaonetomany.region.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionRestController {

    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;

    @GetMapping("/getregioner")
     public List<RegionModel> getRegioner() {
        List<RegionModel> listRegion = apiServiceGetRegioner.getRegioner();
        return listRegion;
    }

}

