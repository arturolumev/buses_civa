package com.prueba.app.service;

import com.prueba.app.DTO.BusesDTO;

import java.util.List;

public interface BusesService {
    List<BusesDTO> getAllBuses();
    BusesDTO getBusById(int id);
}