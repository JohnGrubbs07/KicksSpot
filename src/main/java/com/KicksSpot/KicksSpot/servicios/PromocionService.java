/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.KicksSpot.KicksSpot.servicios;

import com.KicksSpot.KicksSpot.domain.Promocion;
import com.KicksSpot.KicksSpot.repositorios.PromocionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromocionService {
    @Autowired
    private PromocionRepository promocionRepository;

    public List<Promocion> obtenerPromocionesActivas() {
        LocalDate fechaActual = LocalDate.now();
        return promocionRepository.findAll().stream()
                .filter(p -> p.getFechaInicio().isBefore(fechaActual) && p.getFechaFin().isAfter(fechaActual))
                .collect(Collectors.toList());
    }
}