package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.CategoriaDTO;
import com.michilatte.ecomarket.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<CategoriaDTO> getAllCategorias();
    Optional<CategoriaDTO> getCategoriaById(Integer id);
    CategoriaDTO createCategoria(CategoriaDTO categoriaDTO);
    CategoriaDTO updateCategoria(Integer id, CategoriaDTO categoriaDTO);
    void deleteCategoria(Integer id);

}
