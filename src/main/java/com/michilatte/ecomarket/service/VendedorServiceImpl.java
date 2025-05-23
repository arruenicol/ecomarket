package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.CategoriaDTO;
import com.michilatte.ecomarket.dto.EmpresaDTO;
import com.michilatte.ecomarket.dto.VendedorDTO;
import com.michilatte.ecomarket.model.Categoria;
import com.michilatte.ecomarket.model.Empresa;
import com.michilatte.ecomarket.model.Vendedor;
import com.michilatte.ecomarket.repository.CategoriaRepository;
import com.michilatte.ecomarket.repository.EmpresaRepository;
import com.michilatte.ecomarket.repository.VendedorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class VendedorServiceImpl implements VendedorService {

    private final VendedorRepository vendedorRepository;
    private final EmpresaRepository empresaRepository;
    private final CategoriaRepository categoriaRepository;

    @Override
    public List<VendedorDTO> getAllVendedores() {
        return vendedorRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public Optional<VendedorDTO> findVendedorAndEmpresaByIdVendedor(Integer idVendedor) {
        return vendedorRepository.findVendedorAndEmpresaByIdVendedor(idVendedor)
                .map(this::toDTO);
    }

    @Override
    public Optional<VendedorDTO> getVendedorById(Integer id) {
        return vendedorRepository.findById(id)
                .map(this::toDTO);
    }

    @Override
    public VendedorDTO createVendedor(VendedorDTO vendedorDTO, EmpresaDTO empresaDTO) {
        Vendedor vendedor = toEntity(vendedorDTO);
        vendedor = vendedorRepository.save(vendedor);

        Empresa empresa = toEmpresaEntity(empresaDTO, vendedor);
        empresaRepository.save(empresa);

        return toDTO(vendedor);
    }

    @Override
    public VendedorDTO updateVendedor(Integer id, VendedorDTO vendedorDTO) {
        return vendedorRepository.findById(id).map(existing -> {
            existing.setNombre(vendedorDTO.getNombreVendedorDTO());
            existing.setApellido(vendedorDTO.getApellidoVendedorDTO());
            existing.setFechaNacimiento(vendedorDTO.getFechaNacimientoDTO());
            existing.setTelefono(vendedorDTO.getTelefonoDTO());
            existing.setCorreo(vendedorDTO.getCorreoDTO());
            existing.setContrasenia(vendedorDTO.getContraseniaDTO());
            return toDTO(vendedorRepository.save(existing));
        }).orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
    }

    @Override
    public void deleteVendedor(Integer id) {
        vendedorRepository.deleteById(id);
    }


    private Vendedor toEntity(VendedorDTO dto) {

        Vendedor vendedor = Vendedor.builder()
                .idVendedor(dto.getIdVendedorDTO())
                .nombre(dto.getNombreVendedorDTO())
                .apellido(dto.getApellidoVendedorDTO())
                .tipoDoc(dto.getTipoDocDTO())
                .numIdentificador(dto.getNumIdentificadorDTO())
                .fechaNacimiento(dto.getFechaNacimientoDTO())
                .telefono(dto.getTelefonoDTO())
                .correo(dto.getCorreoDTO())
                .contrasenia(dto.getContraseniaDTO())
            .build();
        return vendedor;
    }

    private Empresa toEmpresaEntity(EmpresaDTO dto, Vendedor vendedor) {
        Categoria categoria = categoriaRepository.findById(dto.getMercadoDTO().getIdCategoriaDTO())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        return Empresa.builder()
                .idEmpresa(dto.getIdEmpresa())
                .nombre(dto.getNombreDTO())
                .mercado(categoria)
                .pais(dto.getPaisDTO())
                .numIdentificacion(dto.getNumIdentificacionDTO())
                .vendedor(vendedor)
                .build();
    }



    private VendedorDTO toDTO(Vendedor vendedor) {
        return VendedorDTO.builder()
                .idVendedorDTO(vendedor.getIdVendedor())
                .nombreVendedorDTO(vendedor.getNombre())
                .apellidoVendedorDTO(vendedor.getApellido())
                .tipoDocDTO(vendedor.getTipoDoc())
                .numIdentificadorDTO(vendedor.getNumIdentificador())
                .fechaNacimientoDTO(vendedor.getFechaNacimiento())
                .telefonoDTO(vendedor.getTelefono())
                .correoDTO(vendedor.getCorreo())
                .contraseniaDTO(vendedor.getContrasenia())
                .build();

    }

    private EmpresaDTO toEmpresaDTO(Empresa empresa){
        Categoria categoria = empresa.getMercado();
        CategoriaDTO categoriaDTO = CategoriaDTO.builder()
                .nombreDTO(categoria.getNombre())
                .build();

        return EmpresaDTO.builder()
                .idEmpresa(empresa.getIdEmpresa())
                .nombreDTO(empresa.getNombre())
                .mercadoDTO(categoriaDTO)
                .paisDTO(empresa.getPais())
                .numIdentificacionDTO(empresa.getNumIdentificacion())
                .build();
    }


}