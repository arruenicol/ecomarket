package com.michilatte.ecomarket.api;

import com.michilatte.ecomarket.dto.DireccionDTO;
import com.michilatte.ecomarket.service.DireccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
@RequiredArgsConstructor
public class DireccionRestController {

    private final DireccionService direccionService;

    @PostMapping
    public ResponseEntity<DireccionDTO> create(@RequestBody DireccionDTO direccionDTO) {
        return ResponseEntity.ok(direccionService.save(direccionDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DireccionDTO> getById(@PathVariable Integer id) {
        DireccionDTO dto = direccionService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<DireccionDTO>> getAll() {
        return ResponseEntity.ok(direccionService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        direccionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //falta agregar un putmapping por si el comprador
    //quiere editar sus direcciones
}

