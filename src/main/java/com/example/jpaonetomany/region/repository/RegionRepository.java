package com.example.jpaonetomany.region.repository;

import com.example.jpaonetomany.region.model.RegionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<RegionModel, Integer> {

}
