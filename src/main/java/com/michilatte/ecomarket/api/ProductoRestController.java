package com.michilatte.ecomarket.api;

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
    public ResponseEntity<List<Producto>> getAllProductos() {
        return ResponseEntity.ok(productoService.getAllProductos());
    }

    // producto por id
    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Integer id) {
        return productoService.getProductoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto nuevoProducto) {
        return new ResponseEntity<>(productoService.createProducto(nuevoProducto), HttpStatus.CREATED);
    }

    // actualizar por id
    @PutMapping("/editar/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        try {
            Producto updated = productoService.updateProducto(id, producto);
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
    @GetMapping("/producto")
    public ResponseEntity<Producto> findByNombreProducto(@RequestParam String nombreProducto) {
        return new ResponseEntity<>(productoService.findProductoByNombre(nombreProducto),
                HttpStatus.OK);
    }

    // busca por categoria
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Producto>> getProductosByCategoria(@PathVariable String categoria) {
        return new ResponseEntity<>(productoService.findAllByCategoria(categoria), HttpStatus.OK);
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
