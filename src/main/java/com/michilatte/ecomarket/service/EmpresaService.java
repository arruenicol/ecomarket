package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.EmpresaDTO;
import com.michilatte.ecomarket.dto.VendedorDTO;
import com.michilatte.ecomarket.model.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    List<EmpresaDTO> getAllEmpresas();
    Optional<EmpresaDTO> getEmpresaById(Integer id);
    Optional<EmpresaDTO> findVendedorAndEmpresaByIdVendedor(Integer idVendedor);
    EmpresaDTO createEmpresa(EmpresaDTO empresaDTO, VendedorDTO vendedorDTO);
    EmpresaDTO updateEmpresa(Integer id, EmpresaDTO empresaDTO);
    void deleteEmpresa(Integer id);
}
