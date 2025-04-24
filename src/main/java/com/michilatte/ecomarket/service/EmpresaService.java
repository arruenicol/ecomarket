package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.EmpresaDTO;
import com.michilatte.ecomarket.model.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    List<EmpresaDTO> getAllEmpresas();
    Optional<EmpresaDTO> getEmpresaById(Integer id);
    EmpresaDTO createEmpresa(Empresa empresa);
    EmpresaDTO updateEmpresa(Integer id, Empresa empresa);
    void deleteEmpresa(Integer id);
}
