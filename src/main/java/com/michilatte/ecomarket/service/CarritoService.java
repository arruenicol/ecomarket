package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.model.Carrito;

import java.util.List;

public interface CarritoService {
    Carrito findById(Integer id);
    List<Carrito> findAll();
    Carrito save(Carrito carrito);
    void deleteById(Integer id);
    List<Carrito> findByCompradorId(Integer idComprador);

}
