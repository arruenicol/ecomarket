package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.CarritoDTO;

import java.util.List;

public interface CarritoService {
    CarritoDTO findById(Integer id);
    List<CarritoDTO> findAll();
    CarritoDTO save(CarritoDTO carrito);
    void deleteById(Integer id);
    List<CarritoDTO> findByCompradorId(Integer idComprador);

}
