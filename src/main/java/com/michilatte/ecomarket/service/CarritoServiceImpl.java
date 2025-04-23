package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.CarritoDTO;
import com.michilatte.ecomarket.dto.CarritoItemDTO;
import com.michilatte.ecomarket.dto.CompradorDTO;
import com.michilatte.ecomarket.dto.DireccionDTO;
import com.michilatte.ecomarket.model.Carrito;
import com.michilatte.ecomarket.model.CarritoItem;
import com.michilatte.ecomarket.model.Comprador;
import com.michilatte.ecomarket.repository.CarritoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CarritoServiceImpl implements CarritoService {

    private final CarritoRepository carritoRepository;


    /* ** SERVICIOS ** */
    @Override
    public CarritoDTO findById(Integer id) {
        return carritoRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public List<CarritoDTO> findAll() {
        return carritoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarritoDTO save(CarritoDTO carritoDTO) {
        Carrito carrito = toEntity(carritoDTO);
        return toDTO(carritoRepository.save(carrito));
    }

    @Override
    public void deleteById(Integer id) {
        carritoRepository.deleteById(id);
    }

    @Override
    public List<CarritoDTO> findByCompradorId(Integer idComprador) {
        return carritoRepository.findByComprador(idComprador).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }



    /* ** METODO toEntity ** */
    private Carrito toEntity(CarritoDTO carritoDTO) {
        List<CarritoItem> items = carritoDTO.getItemsDTO() != null
                ? carritoDTO.getItemsDTO().stream()
                .map(d -> CarritoItem.builder()
                        .idCarritoItem(d.getIdCarritoItemDTO())
                        .cantidad(d.getCantidadDTO())
                        //.producto(d.getProductoDTO()) // VER !!!
                        .build())
                .collect(Collectors.toList())
                : null;


        Carrito carrito = Carrito.builder()
                .idCarrito(carritoDTO.getIdCarritoDTO())
                //.comprador(carritoDTO.getCompradorDTO()) // VER !!!
                .items(items)
                .build();

        if (items != null) {
            items.forEach(d -> d.setCarrito(carrito));
        }

        return carrito;
    }


    /* ** METODO toDTO ** */
    private CarritoDTO toDTO(Carrito carrito) {
        List<CarritoItemDTO> itemsDTO = carrito.getItems() != null
                ? carrito.getItems().stream()
                .map(d -> CarritoItemDTO.builder()
                        .idCarritoItemDTO(d.getIdCarritoItem())
                        .cantidadDTO(d.getCantidad())
                        //.productoDTO(d.getProductoDTO()) // VER !!
                        .build())
                .collect(Collectors.toList())
                : null;

        return CarritoDTO.builder()
                .idCarritoDTO(carrito.getIdCarrito())
                //.compradorDTO(carrito.getComprador())  // VER !!
                .itemsDTO(itemsDTO)
                .build();
    }
}