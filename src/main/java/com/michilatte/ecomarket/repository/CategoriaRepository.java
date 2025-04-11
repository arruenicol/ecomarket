package com.michilatte.ecomarket.repository;

import com.michilatte.ecomarket.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    List<Categoria> findByNombreContainingIgnoreCase(String nombre);
}