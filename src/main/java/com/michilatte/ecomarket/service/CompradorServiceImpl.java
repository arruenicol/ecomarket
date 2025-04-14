package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.CompradorDTO;
import com.michilatte.ecomarket.dto.DireccionDTO;
import com.michilatte.ecomarket.model.Comprador;
import com.michilatte.ecomarket.model.Direccion;
import com.michilatte.ecomarket.repository.CompradorRepository;
import com.michilatte.ecomarket.service.CompradorService;
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
        existing.setNombre(dto.getNombreComprador());
        existing.setApellido(dto.getApellidoComprador());
        existing.setTipoDoc(dto.getTipoDoc());
        existing.setNumIdentificador(dto.getNumIdentificador());
        existing.setFechaNacimiento(dto.getFechaNacimientoComprador());
        existing.setTelefono(dto.getTelefonoComprador());
        existing.setCorreo(dto.getCorreo());
        existing.setContrasenia(dto.getContrasenia());
        return toDto(compradorRepository.save(existing));
    }

    private Comprador toEntity(CompradorDTO dto) {
        List<Direccion> direcciones = dto.getDirecciones() != null
                ? dto.getDirecciones().stream()
                .map(d -> Direccion.builder()
                        .idDireccion(d.getIdDireccion())
                        .direccion(d.getDireccion())
                        .comuna(d.getComuna())
                        .region(d.getRegion())
                        .codigoPostal(d.getCodigoPostal())
                        .build())
                .collect(Collectors.toList())
                : null;

        Comprador comprador = Comprador.builder()
                .idComprador(dto.getIdComprador())
                .nombre(dto.getNombreComprador())
                .apellido(dto.getApellidoComprador())
                .tipoDoc(dto.getTipoDoc())
                .numIdentificador(dto.getNumIdentificador())
                .fechaNacimiento(dto.getFechaNacimientoComprador())
                .telefono(dto.getTelefonoComprador())
                .correo(dto.getCorreo())
                .contrasenia(dto.getContrasenia())
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
                        .idDireccion(d.getIdDireccion())
                        .direccion(d.getDireccion())
                        .comuna(d.getComuna())
                        .region(d.getRegion())
                        .codigoPostal(d.getCodigoPostal())
                        .build())
                .collect(Collectors.toList())
                : null;

        return CompradorDTO.builder()
                .idComprador(comprador.getIdComprador())
                .nombreComprador(comprador.getNombre())
                .apellidoComprador(comprador.getApellido())
                .tipoDoc(comprador.getTipoDoc())
                .numIdentificador(comprador.getNumIdentificador())
                .fechaNacimientoComprador(comprador.getFechaNacimiento())
                .telefonoComprador(comprador.getTelefono())
                .correo(comprador.getCorreo())
                .contrasenia(comprador.getContrasenia())
                .direcciones(direcciones)
                .build();
    }
}

