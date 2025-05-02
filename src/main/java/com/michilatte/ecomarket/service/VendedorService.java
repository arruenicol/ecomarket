package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.EmpresaDTO;
import com.michilatte.ecomarket.dto.VendedorDTO;
import com.michilatte.ecomarket.model.Vendedor;

import java.util.List;
import java.util.Optional;

public interface VendedorService {
    List<VendedorDTO> getAllVendedores();
    Optional<VendedorDTO> getVendedorById(Integer id);
    Optional<VendedorDTO> findVendedorAndEmpresaByIdVendedor(Integer idVendedor);
    VendedorDTO createVendedor(VendedorDTO vendedorDTO, EmpresaDTO empresaDTO);
    VendedorDTO updateVendedor(Integer id, VendedorDTO vendedorDTO);
    void deleteVendedor(Integer id);
}
