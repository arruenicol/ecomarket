package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.DireccionDTO;

import java.util.List;

public interface DireccionService {
    DireccionDTO save(DireccionDTO direccionDTO);
    DireccionDTO findById(Integer id);
    List<DireccionDTO> findAll();
    void delete(Integer id);
}
