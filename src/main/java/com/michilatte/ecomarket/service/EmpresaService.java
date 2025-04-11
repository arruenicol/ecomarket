package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.model.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    List<Empresa> getAllEmpresas();
    Optional<Empresa> getEmpresaById(Integer id);
    Empresa createEmpresa(Empresa empresa);
    Empresa updateEmpresa(Integer id, Empresa empresa);
    void deleteEmpresa(Integer id);
}
