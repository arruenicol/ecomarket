package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.model.Producto;
import com.michilatte.ecomarket.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor

public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> getProductoById(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto findProductoByNombre(String nombreProducto) {
        return productoRepository.findByNombreProducto(nombreProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Integer id, Producto producto) {
        return productoRepository.findById(id).map(existing -> {
            existing.setNombreProducto(producto.getNombreProducto());
            existing.setEstadoStock(producto.getEstadoStock());
            existing.setDescripcion(producto.getDescripcion());
            existing.setCategoria(producto.getCategoria());
            return productoRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public void deleteProducto(Integer id) {
        productoRepository.deleteById(id);
    }


    @Override
    public List<Producto> findAllByCategoria(String categoria) {
        return productoRepository.findAllByCategoria(categoria);
    }

    @Override
    public List<Producto> findAllByRangoPrecio(Double min, Double max){
        //validamos q los datos no vengan vacíos
        if (min == null && max == null) {
            throw new IllegalArgumentException("Precios no deben ser nulos");
        }

        //validamos que el minimo no sea mayor al máximo
        if (min > max) {
            throw new IllegalArgumentException("Precios debe ser mayor que el maximo");
        }

        //
        return productoRepository.findAllByRangoPrecio(min, max);
    }

}
