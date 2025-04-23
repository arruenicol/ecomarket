package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.CategoriaDTO;
import com.michilatte.ecomarket.dto.EmpresaDTO;
import com.michilatte.ecomarket.dto.ProductoDTO;
import com.michilatte.ecomarket.model.*;
import com.michilatte.ecomarket.repository.EmpresaRepository;
import com.michilatte.ecomarket.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor

public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> getAllProductos() {
        return productoRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductoDTO> getProductoById(Integer id) {
        return productoRepository.findById(id)
                .map(this::toDto);
    }

    @Override
    public List<ProductoDTO> findProductoByNombre(String nombreProducto) {
        return productoRepository.findByNombreProductoContainingIgnoreCase(nombreProducto).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO createProducto(ProductoDTO productoDTO) {
        Producto producto = toEntity(productoDTO);
        return toDto(productoRepository.save(producto));
    }

    @Override
    public ProductoDTO updateProducto(Integer id, ProductoDTO productoDTO) {
        return productoRepository.findById(id).map(existing -> {
            existing.setNombreProducto(productoDTO.getNombreProductoDTO());
            existing.setDescripcion(productoDTO.getDescripcionDTO());
            //existing.setCategoria(productoDTO.getCategoriaDTO());
            return toDto(productoRepository.save(existing));
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public void deleteProducto(Integer id) {
        productoRepository.deleteById(id);
    }


    @Override
    public List<ProductoDTO> findAllByCategoria(String categoria) {
        return productoRepository.findAllByCategoria(categoria).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Producto> findAllByRangoPrecio(Double min, Double max) {
        //validamos q los datos no vengan vacíos
        if (min == null && max == null) {
            throw new IllegalArgumentException("Precios no deben ser nulos");
        }

        //validamos que el minimo no sea mayor al máximo
        if (min > max) {
            throw new IllegalArgumentException("Precios debe ser mayor que el maximo");
        }
        //
        return productoRepository.findAllByRangoPrecio(min, max);
    }

    private final EmpresaRepository empresaRepository; // asegúrate de tenerlo inyectado


    private Producto toEntity(ProductoDTO dto) {

        Empresa empresa = empresaRepository.findById(dto.getEmpresaDTO().getIdEmpresa())
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada con ID: " + dto.getEmpresaDTO().getIdEmpresa()));

        Categoria categoria = Categoria.builder()

                .idCategoria(dto.getCategoriaDTO().getIdCategoriaDTO())
                .nombre(dto.getCategoriaDTO().getNombreDTO())
                .descripcion(dto.getCategoriaDTO().getDescripcionDTO())
                .build();

        Producto producto = Producto.builder()
                .idProducto(dto.getIdProductoDTO())
                .nombreProducto(dto.getNombreProductoDTO())
                .categoria(categoria)
                .descripcion(dto.getDescripcionDTO())
                .empresa(empresa)
                .precio(dto.getPrecioDTO())
                .cantidad(dto.getCantidadDTO())
                .build();

        return producto;
    }

    private ProductoDTO toDto(Producto producto) {
        Empresa empresa = producto.getEmpresa();

        if (empresa == null) {
            System.out.println("⚠️ Producto con ID " + producto.getIdProducto() + " no tiene empresa asociada.");
            throw new RuntimeException("El producto no tiene empresa asociada");
        }

        Categoria categoria = producto.getCategoria();

        CategoriaDTO categoriaDTO = CategoriaDTO.builder()
                .idCategoriaDTO(categoria.getIdCategoria())
                .nombreDTO(categoria.getNombre())
                .descripcionDTO(categoria.getDescripcion())
                .build();

        EmpresaDTO empresaDTO = EmpresaDTO.builder()
                .idEmpresa(empresa.getIdEmpresa())
                .nombreDTO(empresa.getNombre())
                .mercadoDTO(empresa.getMercado())
                .paisDTO(empresa.getPais())
                .numIdentificacionDTO(empresa.getNumIdentificacion())
                .build();

        return ProductoDTO.builder()
                .idProductoDTO(producto.getIdProducto())
                .nombreProductoDTO(producto.getNombreProducto())
                .categoriaDTO(categoriaDTO)
                .descripcionDTO(producto.getDescripcion())
                .empresaDTO(empresaDTO)
                .precioDTO(producto.getPrecio())
                .cantidadDTO(producto.getCantidad())
                .build();
    }



}