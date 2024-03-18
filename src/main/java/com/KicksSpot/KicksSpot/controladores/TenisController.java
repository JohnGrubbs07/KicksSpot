/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.KicksSpot.KicksSpot.controladores;

import com.KicksSpot.KicksSpot.domain.Tenis;
import com.KicksSpot.KicksSpot.servicios.TenisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TenisController {
    @Autowired
    private TenisService tenisService;

    @GetMapping("/busqueda")
    public String mostrarFormularioBusqueda() {
        return "busqueda";
    }

    @PostMapping("/busqueda")
    public String realizarBusqueda(@RequestParam(required = false) String marca,
                                   @RequestParam(required = false) String talla,
                                   @RequestParam(required = false) String color,
                                   Model model) {
        List<Tenis> resultados = tenisService.buscarTenis(marca, talla, color);
        model.addAttribute("resultados", resultados);
        return "resultados";
    }
}