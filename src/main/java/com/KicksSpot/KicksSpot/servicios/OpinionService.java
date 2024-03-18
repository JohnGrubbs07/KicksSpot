/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.KicksSpot.KicksSpot.servicios;

import com.KicksSpot.KicksSpot.domain.Opinion;
import com.KicksSpot.KicksSpot.domain.Tenis;
import com.KicksSpot.KicksSpot.repositorios.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OpinionService {
    @Autowired
    private OpinionRepository opinionRepository;

    public void guardarOpinion(Opinion opinion) {
        opinionRepository.save(opinion);
    }

    public List<Opinion> obtenerOpinionesPorTenis(Tenis tenis) {
        return opinionRepository.findAll().stream()
                .filter(opinion -> opinion.getTenis().getId().equals(tenis.getId()))
                .collect(Collectors.toList());
    }
}