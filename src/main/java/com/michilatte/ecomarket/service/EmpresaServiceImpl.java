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
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final VendedorRepository vendedorRepository;
    private final CategoriaRepository categoriaRepository;


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
    public Optional<EmpresaDTO> findVendedorAndEmpresaByIdVendedor(Integer idVendedor) {
        return empresaRepository.findVendedorAndEmpresaByIdVendedor(idVendedor)
                .map(this::toDTO);
    }


    @Override
    public EmpresaDTO createEmpresa(EmpresaDTO empresaDTO, VendedorDTO vendedorDTO) {
        Vendedor vendedor = toVendedorEntity(vendedorDTO);
        vendedorRepository.save(vendedor);

        Empresa empresa = toEntity(empresaDTO, vendedor);
        empresa = empresaRepository.save(empresa);


        return toDTO(empresa);
    }


    @Override
    public EmpresaDTO updateEmpresa(Integer id, EmpresaDTO empresaDTO) {
        return empresaRepository.findById(id).map(existing -> {
            existing.setNombre(empresaDTO.getNombreDTO());
            existing.setMercado(existing.getMercado());
            existing.setPais(empresaDTO.getPaisDTO());
            existing.setVendedor(existing.getVendedor());
            return toDTO(empresaRepository.save(existing));
        }).orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
    }

    @Override
    public void deleteEmpresa(Integer id) {
        empresaRepository.deleteById(id);
    }



    private Empresa toEntity(EmpresaDTO dto, Vendedor vendedor) {
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

    private Vendedor toVendedorEntity(VendedorDTO dto) {

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


    private EmpresaDTO toDTO(Empresa empresa){
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
                .vendedorDTO(toVendedorDTO(empresa.getVendedor()))
                .build();
    }

    private VendedorDTO toVendedorDTO(Vendedor vendedor) {
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

}