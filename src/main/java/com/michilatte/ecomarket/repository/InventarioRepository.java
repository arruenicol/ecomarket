package com.michilatte.ecomarket.repository;

import com.michilatte.ecomarket.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
    List<Inventario> findByEmpresaIdEmpresa(Integer idEmpresa);
    List<Inventario> findByProductoIdProducto(Integer idProducto);
}
