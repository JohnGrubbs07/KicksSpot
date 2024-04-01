/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.KicksSpot.KicksSpot.controladores;

import com.KicksSpot.KicksSpot.servicios.ProgramaLealtadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgramaLealtadController {
    @Autowired
    private ProgramaLealtadService programaLealtadService;

    @GetMapping("/programa-lealtad")
    public String mostrarProgramaLealtad(Model model) {
        model.addAttribute("clientesPremium", programaLealtadService.obtenerClientesPremium());
        return "programa-lealtad";
    }
}