package com.michilatte.ecomarket.api;

import com.michilatte.ecomarket.dto.ProductoDTO;
import com.michilatte.ecomarket.model.ECategoria;
import com.michilatte.ecomarket.model.Producto;
import com.michilatte.ecomarket.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoRestController {

    private final ProductoService productoService;

    // devuelve todos los productos
    @GetMapping("/lista")
    public ResponseEntity<List<ProductoDTO>> getAllProductos() {
        return ResponseEntity.ok(productoService.getAllProductos());
    }

    // producto por id
    @GetMapping("/id/{id}")
    public ResponseEntity<ProductoDTO> getProductoById(@PathVariable Integer id) {
        return productoService.getProductoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoDTO nuevoProducto) {
        return new ResponseEntity<>(productoService.createProducto(nuevoProducto), HttpStatus.CREATED);
    }

    // actualizar por id
    @PutMapping("/editar/{id}")
    public ResponseEntity<ProductoDTO> updateProducto(@PathVariable Integer id, @RequestBody ProductoDTO productoDTO) {
        try {
            ProductoDTO updated = productoService.updateProducto(id, productoDTO);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // borrar por id
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Integer id) {
        productoService.deleteProducto(id);
        return new ResponseEntity<>("El producto ha sido eliminado", HttpStatus.OK);
    }


    //buscar por nombre de producto
    @GetMapping("/nombre/{nombreProducto}")
    public ResponseEntity<List<ProductoDTO>> findByNombreProducto(@PathVariable String nombreProducto) {
        return new ResponseEntity<>(productoService.findProductoByNombre(nombreProducto),
                HttpStatus.OK);
    }

    // busca por categoria
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ProductoDTO>> getProductosByCategoria(@PathVariable String categoria) {
        return new ResponseEntity<>(productoService.findAllByCategoria(categoria),
                HttpStatus.OK);
    }

    //por precio

    @GetMapping("/precio")
    public ResponseEntity<List<Producto>> getProductosByPrecioRango(
            @RequestParam Double min,
            @RequestParam Double max) {
        try {
            return ResponseEntity.ok(productoService.findAllByRangoPrecio(min, max));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
