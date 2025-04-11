package com.michilatte.ecomarket.api;

import com.michilatte.ecomarket.model.Vendedor;
import com.michilatte.ecomarket.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendedores")
@RequiredArgsConstructor
public class VendedorRestController {

    private final VendedorService vendedorService;


    @GetMapping
    public List<Vendedor> getAll() {
        return vendedorService.getAllVendedores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> getById(@PathVariable Integer id) {
        return vendedorService.getVendedorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vendedor> create(@RequestBody Vendedor vendedor) {
        return new ResponseEntity<>(vendedorService.createVendedor(vendedor), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> update(@PathVariable Integer id, @RequestBody Vendedor vendedor) {
        try {
            return ResponseEntity.ok(vendedorService.updateVendedor(id, vendedor));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        vendedorService.deleteVendedor(id);
        return ResponseEntity.noContent().build();
    }
}

