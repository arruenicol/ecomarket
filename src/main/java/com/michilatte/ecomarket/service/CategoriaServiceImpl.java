package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.CategoriaDTO;
import com.michilatte.ecomarket.model.Categoria;
import com.michilatte.ecomarket.model.Producto;
import com.michilatte.ecomarket.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;


    @Override
    public List<CategoriaDTO> getAllCategorias() {
        return categoriaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoriaDTO> getCategoriaById(Integer id) {
        return categoriaRepository.findById(id)
                .map(this::toDTO);
    }

    @Override
    public CategoriaDTO createCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = toEntity(categoriaDTO);
        return toDTO(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaDTO updateCategoria(Integer id, CategoriaDTO categoriaDTO) {
        return categoriaRepository.findById(id).map(existing -> {
            existing.setNombre(categoriaDTO.getNombreDTO());
            existing.setDescripcion(categoriaDTO.getDescripcionDTO());
            return toDTO(categoriaRepository.save(existing));
        }).orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    @Override
    public void deleteCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }





    private Categoria toEntity(CategoriaDTO dto) {
        Categoria categoria = Categoria.builder()
                .idCategoria(dto.getIdCategoriaDTO())
                .nombre(dto.getNombreDTO())
                .descripcion(dto.getDescripcionDTO())
                .build();

        return categoria;

    }

    private CategoriaDTO toDTO(Categoria categoria) {
        return CategoriaDTO.builder()
                .idCategoriaDTO(categoria.getIdCategoria())
                .nombreDTO(categoria.getNombre())
                .descripcionDTO(categoria.getDescripcion())
                .build();

    }


}
