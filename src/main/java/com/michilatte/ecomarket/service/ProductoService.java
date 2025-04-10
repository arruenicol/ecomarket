package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> getAllProductos();
    Optional<Producto> getProductoById(Integer id);
    Producto findProductoByNombre(String nombre);
    Producto createProducto(Producto producto);
    Producto updateProducto(Integer id, Producto producto);
    void deleteProducto(Integer id);

    List<Producto> findAllByCategoria(String nombreCategoria);
    List<Producto> findAllByRangoPrecio(Double min, Double max);
}
