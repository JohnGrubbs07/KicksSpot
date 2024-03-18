/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.KicksSpot.KicksSpot.servicios;

import com.KicksSpot.KicksSpot.domain.Tenis;
import com.KicksSpot.KicksSpot.repositorios.TenisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TenisService {
    @Autowired
    private TenisRepository tenisRepository;

    public List<Tenis> buscarTenis(String marca, String talla, String color) {
        List<Tenis> tenisList = tenisRepository.findAll();

        if (marca != null && !marca.isEmpty()) {
            tenisList = tenisList.stream()
                    .filter(tenis -> tenis.getMarca().equalsIgnoreCase(marca))
                    .collect(Collectors.toList());
        }

        if (talla != null && !talla.isEmpty()) {
            tenisList = tenisList.stream()
                    .filter(tenis -> tenis.getTalla().equalsIgnoreCase(talla))
                    .collect(Collectors.toList());
        }

        if (color != null && !color.isEmpty()) {
            tenisList = tenisList.stream()
                    .filter(tenis -> tenis.getColor().equalsIgnoreCase(color))
                    .collect(Collectors.toList());
        }

        return tenisList;
    }

    public Tenis obtenerTenisPorId(Long id) {
        return tenisRepository.findById(id).orElse(null);
    }
}