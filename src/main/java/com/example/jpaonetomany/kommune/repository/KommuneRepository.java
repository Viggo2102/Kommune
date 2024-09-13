package com.example.jpaonetomany.kommune.repository;

import com.example.jpaonetomany.kommune.model.KommuneModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KommuneRepository extends JpaRepository<KommuneModel, Integer> {

    List<KommuneModel> findAllByNavn(String navn);
}
