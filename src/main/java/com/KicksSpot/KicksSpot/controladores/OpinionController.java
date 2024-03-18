/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.KicksSpot.KicksSpot.controladores;

import com.KicksSpot.KicksSpot.domain.Opinion;
import com.KicksSpot.KicksSpot.domain.Tenis;
import com.KicksSpot.KicksSpot.servicios.OpinionService;
import com.KicksSpot.KicksSpot.servicios.TenisService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class OpinionController {
    @Autowired
    private OpinionService opinionService;
    @Autowired
    private TenisService tenisService;

    @GetMapping("/tenis/{id}")
    public String mostrarDetallesTenis(@PathVariable Long id, Model model) {
        Tenis tenis = tenisService.obtenerTenisPorId(id);
        List<Opinion> opiniones = opinionService.obtenerOpinionesPorTenis(tenis);
        model.addAttribute("tenis", tenis);
        model.addAttribute("opiniones", opiniones);
        model.addAttribute("nuevaOpinion", new Opinion());
        return "detalles";
    }

    @PostMapping("/tenis/{id}/opinion")
    public String guardarOpinion(@PathVariable Long id, @ModelAttribute("nuevaOpinion") Opinion nuevaOpinion) {
        Tenis tenis = tenisService.obtenerTenisPorId(id);
        Opinion opinion = new Opinion(null, nuevaOpinion.getValoracion(), nuevaOpinion.getComentario(), LocalDateTime.now(), tenis);
        opinionService.guardarOpinion(opinion);
        return "redirect:/tenis/" + id;
    }
}
