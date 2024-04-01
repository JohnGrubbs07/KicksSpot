/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.KicksSpot.KicksSpot.controladores;

import com.KicksSpot.KicksSpot.servicios.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PromocionController {
    @Autowired
    private PromocionService promocionService;

    @GetMapping("/promociones")
    public String mostrarPromocionesActivas(Model model) {
        model.addAttribute("promociones", promocionService.obtenerPromocionesActivas());
        return "promociones";
    }
}