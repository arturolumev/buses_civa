package com.prueba.app.service;

import com.prueba.app.BusesRepo.BusesRepo;
import com.prueba.app.DTO.BusesDTO;
import com.prueba.app.entity.Buses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusesServiceIMPL implements BusesService {
    @Autowired
    private BusesRepo busesRepo;

    @Override
    public List<BusesDTO> getAllBuses() {
        List<Buses> getbuses = busesRepo.findAll();
        List<BusesDTO> busesDTOList = new ArrayList<>();
        for (Buses a : getbuses) {
            BusesDTO busesDTO = new BusesDTO(
                    a.getBusesid(),
                    a.getBusesnumero(),
                    a.getBusesplaca(),
                    a.getBusesfecha(),
                    a.getBusescaracteristicas(),
                    a.getBusesmarca(),
                    a.getBusesmarcanombre() != null ? a.getBusesmarcanombre().getNombre() : null,
                    a.getBusesestado());
            busesDTOList.add(busesDTO);
        }

        return busesDTOList;
    }

    @Override
    public BusesDTO getBusById(int id) {
        Buses bus = busesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus not found with ID: " + id));

        return new BusesDTO(
                bus.getBusesid(),
                bus.getBusesnumero(),
                bus.getBusesplaca(),
                bus.getBusesfecha(),
                bus.getBusescaracteristicas(),
                bus.getBusesmarca(),
                bus.getBusesmarcanombre() != null ? bus.getBusesmarcanombre().getNombre() : null,
                bus.getBusesestado());
    }

}