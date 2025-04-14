package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.DireccionDTO;
import com.michilatte.ecomarket.model.Direccion;
import com.michilatte.ecomarket.repository.DireccionRepository;
import com.michilatte.ecomarket.service.DireccionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DireccionServiceImpl implements DireccionService {

    private final DireccionRepository direccionRepository;

    @Override
    public DireccionDTO save(DireccionDTO dto) {
        Direccion direccion = toEntity(dto);
        return toDto(direccionRepository.save(direccion));
    }

    @Override
    public DireccionDTO findById(Integer id) {
        return direccionRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    @Override
    public List<DireccionDTO> findAll() {
        return direccionRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        direccionRepository.deleteById(id);
    }

    private DireccionDTO toDto(Direccion d) {
        return DireccionDTO.builder()
                .idDireccion(d.getIdDireccion())
                .direccion(d.getDireccion())
                .comuna(d.getComuna())
                .region(d.getRegion())
                .codigoPostal(d.getCodigoPostal())
                .build();
    }

    private Direccion toEntity(DireccionDTO d) {
        return Direccion.builder()
                .idDireccion(d.getIdDireccion())
                .direccion(d.getDireccion())
                .comuna(d.getComuna())
                .region(d.getRegion())
                .codigoPostal(d.getCodigoPostal())
                .build();
    }
}
