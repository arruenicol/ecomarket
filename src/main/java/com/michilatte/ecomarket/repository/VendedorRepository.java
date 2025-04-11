package com.michilatte.ecomarket.repository;

import com.michilatte.ecomarket.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
    List<Vendedor> findByNombre(String nombre);
}
