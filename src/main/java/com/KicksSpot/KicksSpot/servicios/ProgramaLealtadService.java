/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.KicksSpot.KicksSpot.servicios;

import com.KicksSpot.KicksSpot.domain.Cliente;
import com.KicksSpot.KicksSpot.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramaLealtadService {
    @Autowired
    private ClienteRepository clienteRepository;

    public void acumularPuntos(Cliente cliente, int puntos) {
        cliente.setPuntos(cliente.getPuntos() + puntos);
        clienteRepository.save(cliente);
    }

    public void canjearPuntos(Cliente cliente, int puntos) {
        if (cliente.getPuntos() >= puntos) {
            cliente.setPuntos(cliente.getPuntos() - puntos);
            clienteRepository.save(cliente);
        }
    }

    public List<Cliente> obtenerClientesPremium() {
        int puntosPremium = 1000; 
        return clienteRepository.findAll().stream()
                .filter(cliente -> cliente.getPuntos() >= puntosPremium)
                .collect(Collectors.toList());
    }
}