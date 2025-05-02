package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.dto.CarritoItemDTO;
import com.michilatte.ecomarket.dto.ProductoDTO;
import com.michilatte.ecomarket.model.CarritoItem;
import com.michilatte.ecomarket.model.Producto;
import com.michilatte.ecomarket.repository.CarritoItemRepository;
import com.michilatte.ecomarket.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CarritoItemServiceImpl implements CarritoItemService {

    private final CarritoItemRepository carritoItemRepository;
    private final ProductoRepository productoRepository;

    @Override public CarritoItemDTO saveCarritoItem(CarritoItemDTO itemDTO) {
        CarritoItem carritoItem = toEntity(itemDTO);
        return toDTO(carritoItemRepository.save(carritoItem));
    }

    @Override public CarritoItemDTO updateCarritoItem(Integer id, CarritoItemDTO itemDTO) {
        CarritoItem existing = carritoItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item no encontrado"));
        existing.setCantidad(itemDTO.getCantidadDTO());
        return toDTO(carritoItemRepository.save(existing));
    }

    @Override public void delete(Integer id) {
        carritoItemRepository.deleteById(id);
    }




    /* ** METODO toEntity ** */
    private CarritoItem toEntity(CarritoItemDTO dto) {

        Producto producto = productoRepository.findById(dto.getProductoDTO().getIdProductoDTO())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        CarritoItem carritoItem = CarritoItem.builder()
                .idCarritoItem(dto.getIdCarritoItemDTO())
                .cantidad(dto.getCantidadDTO())
                .producto(producto)
                .build();
        return carritoItem;
    }



    /* ** METODO toDTO ** */
    private CarritoItemDTO toDTO(CarritoItem item) {

        Producto producto = item.getProducto();
        ProductoDTO productoDTO = ProductoDTO.builder()
                .idProductoDTO(producto.getIdProducto())
                .build();

        return CarritoItemDTO.builder()
                .idCarritoItemDTO(item.getIdCarritoItem())
                .cantidadDTO(item.getCantidad())  // VER !!
                .productoDTO(productoDTO)
                .build();
    }

}
