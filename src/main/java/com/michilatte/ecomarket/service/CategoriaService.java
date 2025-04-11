package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> getAllCategorias();
    Optional<Categoria> getCategoriaById(Integer id);
    Categoria createCategoria(Categoria categoria);
    Categoria updateCategoria(Integer id, Categoria categoria);
    void deleteCategoria(Integer id);
}
