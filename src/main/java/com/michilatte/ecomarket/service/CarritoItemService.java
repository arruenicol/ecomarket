package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.CarritoItemDTO;

public interface CarritoItemService {
    CarritoItemDTO saveCarritoItem(CarritoItemDTO carritoItemDTO);
    CarritoItemDTO updateCarritoItem(Integer id, CarritoItemDTO carritoItemDTO);
    void delete(Integer id);
}
