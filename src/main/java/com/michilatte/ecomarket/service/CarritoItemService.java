package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.model.CarritoItem;

public interface CarritoItemService {

    CarritoItem save(CarritoItem item);

    void delete(Integer id);
}
