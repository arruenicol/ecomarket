package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.DireccionDTO;
import com.michilatte.ecomarket.model.Direccion;
import com.michilatte.ecomarket.repository.DireccionRepository;
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
        return toDTO(direccionRepository.save(direccion));
    }

    @Override
    public DireccionDTO findById(Integer id) {
        return direccionRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public List<DireccionDTO> findAll() {
        return direccionRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        direccionRepository.deleteById(id);
    }

    private DireccionDTO toDTO(Direccion d) {
        return DireccionDTO.builder()
                .idDireccionDTO(d.getIdDireccion())
                .direccionDTO(d.getDireccion())
                .comunaDTO(d.getComuna())
                .regionDTO(d.getRegion())
                .codigoPostalDTO(d.getCodigoPostal())
                .build();
    }

    private Direccion toEntity(DireccionDTO d) {
        return Direccion.builder()
                .idDireccion(d.getIdDireccionDTO())
                .direccion(d.getDireccionDTO())
                .comuna(d.getComunaDTO())
                .region(d.getRegionDTO())
                .codigoPostal(d.getCodigoPostalDTO())
                .build();
    }
}
