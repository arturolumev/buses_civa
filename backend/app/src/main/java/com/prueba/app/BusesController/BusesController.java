package com.prueba.app.BusesController;

import com.prueba.app.DTO.BusesDTO;
import com.prueba.app.service.BusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/buses")
public class BusesController {
    @Autowired
    private BusesService busesService;

    @GetMapping(path = "/getAllBuses")
    public List<BusesDTO> getAllBuses() {
        List<BusesDTO> allBuses = busesService.getAllBuses();
        return allBuses;
    }

    @GetMapping(path = "/getBusById/{id}")
    public BusesDTO getBusById(@PathVariable("id") int id) {
        return busesService.getBusById(id);
    }

}