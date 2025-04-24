package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.EmpresaDTO;
import com.michilatte.ecomarket.model.Empresa;
import com.michilatte.ecomarket.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Override
    public List<EmpresaDTO> getAllEmpresas() {
        return empresaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmpresaDTO> getEmpresaById(Integer id) {
        return empresaRepository.findById(id)
                .map(this::toDTO);
    }

    @Override
    public EmpresaDTO createEmpresa(Empresa empresa) {
        return toDTO(empresaRepository.save(empresa));
    }

    @Override
    public EmpresaDTO updateEmpresa(Integer id, Empresa empresa) {
        return empresaRepository.findById(id).map(existing -> {
            existing.setNombre(empresa.getNombre());
            existing.setMercado(empresa.getMercado());
            existing.setPais(empresa.getPais());
            existing.setNumIdentificacion(empresa.getNumIdentificacion());
            existing.setVendedor(empresa.getVendedor());
            return toDTO(empresaRepository.save(existing));
        }).orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
    }

    @Override
    public void deleteEmpresa(Integer id) {
        empresaRepository.deleteById(id);
    }





    private EmpresaDTO toDTO(Empresa empresa){
        return EmpresaDTO.builder()
                .idEmpresa(empresa.getIdEmpresa()).build();
    }
}




