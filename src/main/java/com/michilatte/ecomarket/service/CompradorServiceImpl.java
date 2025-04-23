package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.CompradorDTO;
import com.michilatte.ecomarket.dto.DireccionDTO;
import com.michilatte.ecomarket.model.Comprador;
import com.michilatte.ecomarket.model.Direccion;
import com.michilatte.ecomarket.repository.CompradorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CompradorServiceImpl implements CompradorService {

    private final CompradorRepository compradorRepository;

    @Override
    public CompradorDTO save(CompradorDTO dto) {
        Comprador comprador = toEntity(dto);
        return toDto(compradorRepository.save(comprador));
    }

    @Override
    public CompradorDTO findById(Integer id) {
        return compradorRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    @Override
    public List<CompradorDTO> findAll() {
        return compradorRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        compradorRepository.deleteById(id);
    }

    @Override
    public CompradorDTO update(Integer id, CompradorDTO dto) {
        Comprador existing = compradorRepository.findById(id).orElseThrow();
        existing.setNombre(dto.getNombreCompradorDTO());
        existing.setApellido(dto.getApellidoCompradorDTO());
        existing.setTipoDoc(dto.getTipoDocDTO());
        existing.setNumIdentificador(dto.getNumIdentificadorDTO());
        existing.setFechaNacimiento(dto.getFechaNacimientoCompradorDTO());
        existing.setTelefono(dto.getTelefonoCompradorDTO());
        existing.setCorreo(dto.getCorreoDTO());
        existing.setContrasenia(dto.getContraseniaDTO());
        return toDto(compradorRepository.save(existing));
    }

    private Comprador toEntity(CompradorDTO dto) {
        List<Direccion> direcciones = dto.getDireccionesDTO() != null
                ? dto.getDireccionesDTO().stream()
                .map(d -> Direccion.builder()
                        .idDireccion(d.getIdDireccionDTO())
                        .direccion(d.getDireccionDTO())
                        .comuna(d.getComunaDTO())
                        .region(d.getRegionDTO())
                        .codigoPostal(d.getCodigoPostalDTO())
                        .build())
                .collect(Collectors.toList())
                : null;

        Comprador comprador = Comprador.builder()
                .idComprador(dto.getIdCompradorDTO())
                .nombre(dto.getNombreCompradorDTO())
                .apellido(dto.getApellidoCompradorDTO())
                .tipoDoc(dto.getTipoDocDTO())
                .numIdentificador(dto.getNumIdentificadorDTO())
                .fechaNacimiento(dto.getFechaNacimientoCompradorDTO())
                .telefono(dto.getTelefonoCompradorDTO())
                .correo(dto.getCorreoDTO())
                .contrasenia(dto.getContraseniaDTO())
                .direcciones(direcciones)
                .build();

        if (direcciones != null) {
            direcciones.forEach(d -> d.setComprador(comprador));
        }

        return comprador;
    }

    private CompradorDTO toDto(Comprador comprador) {
        List<DireccionDTO> direcciones = comprador.getDirecciones() != null
                ? comprador.getDirecciones().stream()
                .map(d -> DireccionDTO.builder()
                        .idDireccionDTO(d.getIdDireccion())
                        .direccionDTO(d.getDireccion())
                        .comunaDTO(d.getComuna())
                        .regionDTO(d.getRegion())
                        .codigoPostalDTO(d.getCodigoPostal())
                        .build())
                .collect(Collectors.toList())
                : null;

        return CompradorDTO.builder()
                .idCompradorDTO(comprador.getIdComprador())
                .nombreCompradorDTO(comprador.getNombre())
                .apellidoCompradorDTO(comprador.getApellido())
                .tipoDocDTO(comprador.getTipoDoc())
                .numIdentificadorDTO(comprador.getNumIdentificador())
                .fechaNacimientoCompradorDTO(comprador.getFechaNacimiento())
                .telefonoCompradorDTO(comprador.getTelefono())
                .correoDTO(comprador.getCorreo())
                .contraseniaDTO(comprador.getContrasenia())
                .direccionesDTO(direcciones)
                .build();
    }
}
