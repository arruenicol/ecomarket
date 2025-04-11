package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.model.Inventario;

import java.util.List;
import java.util.Optional;

public interface InventarioService {
    List<Inventario> getAllInventarios();
    Optional<Inventario> getInventarioById(Integer id);
    Inventario saveInventario(Inventario inventario);
    Inventario updateInventario(Integer id, Inventario inventario);
    void deleteInventario(Integer id);

    List<Inventario> findByProductoId(Integer id);
    List<Inventario> findByEmpresaId(Integer id);
}
