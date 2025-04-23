package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.ProductoDTO;
import com.michilatte.ecomarket.model.ECategoria;
import com.michilatte.ecomarket.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<ProductoDTO> getAllProductos();
    Optional<ProductoDTO> getProductoById(Integer id);
    List<ProductoDTO> findProductoByNombre(String nombreProducto);
    ProductoDTO createProducto(ProductoDTO productoDTO);
    ProductoDTO updateProducto(Integer id, ProductoDTO productoDTO);
    void deleteProducto(Integer id);

    List<ProductoDTO> findAllByCategoria(String nombreCategoria);
    List<Producto> findAllByRangoPrecio(Double min, Double max);
}