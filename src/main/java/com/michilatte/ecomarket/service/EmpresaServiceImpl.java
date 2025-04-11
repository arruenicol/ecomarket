package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.model.Empresa;
import com.michilatte.ecomarket.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    public Optional<Empresa> getEmpresaById(Integer id) {
        return empresaRepository.findById(id);
    }

    @Override
    public Empresa createEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public Empresa updateEmpresa(Integer id, Empresa empresa) {
        return empresaRepository.findById(id).map(existing -> {
            existing.setNombre(empresa.getNombre());
            existing.setMercado(empresa.getMercado());
            existing.setPais(empresa.getPais());
            existing.setNumIdentificacion(empresa.getNumIdentificacion());
            existing.setVendedor(empresa.getVendedor());
            return empresaRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
    }

    @Override
    public void deleteEmpresa(Integer id) {
        empresaRepository.deleteById(id);
    }
}
