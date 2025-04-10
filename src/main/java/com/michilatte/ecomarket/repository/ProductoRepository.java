package com.michilatte.ecomarket.repository;

import com.michilatte.ecomarket.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByEstadoStock(Boolean estadoStock);

    Optional<Producto> findByNombre(String nombre);

    // Buscar productos por nombre de categoría (usando la relación con Categoria)
    @Query("SELECT p FROM Producto p WHERE p.categoria.nombre = :nombreCategoria")
    List<Producto> findAllByCategoria(@Param("nombreCategoria") String nombreCategoria);

    // Buscar productos dentro de un rango de precios
    @Query("SELECT p FROM Producto p JOIN Inventario i ON p.idProducto = i.producto.idProducto WHERE i.precio BETWEEN :min AND :max")
    List<Producto> findAllByRangoPrecio(@Param("min") Double min, @Param("max") Double max);

}
