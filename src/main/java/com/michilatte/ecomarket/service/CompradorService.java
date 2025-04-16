package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.CompradorDTO;
import com.michilatte.ecomarket.model.Comprador;

import java.util.List;

public interface CompradorService {
    CompradorDTO save(CompradorDTO compradorDTO);
    CompradorDTO findById(Integer id);
    List<CompradorDTO> findAll();
    void delete(Integer id);
    CompradorDTO update(Integer id, CompradorDTO compradorDTO);

}

