package com.michilatte.ecomarket.api;
import com.michilatte.ecomarket.dto.CarritoDTO;
import com.michilatte.ecomarket.service.CarritoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrito")
@RequiredArgsConstructor
public class CarritoRestController {

    private final CarritoService carritoService;

    @PostMapping("/nuevo")
    public ResponseEntity<CarritoDTO> create(@RequestBody CarritoDTO carritoDTO) {
        return ResponseEntity.ok(carritoService.save(carritoDTO));
    }

    @GetMapping("/lista")
    public ResponseEntity<List<CarritoDTO>> getAll() {
        return ResponseEntity.ok(carritoService.findAll());
    }

}