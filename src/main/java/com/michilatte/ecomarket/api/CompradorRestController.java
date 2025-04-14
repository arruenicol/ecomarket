package com.michilatte.ecomarket.api;

import com.michilatte.ecomarket.dto.CompradorDTO;
import com.michilatte.ecomarket.service.CompradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compradores")
@RequiredArgsConstructor
public class CompradorRestController {

    private final CompradorService compradorService;

    @PostMapping("/nuevo")
    public ResponseEntity<CompradorDTO> create(@RequestBody CompradorDTO compradorDTO) {
        return ResponseEntity.ok(compradorService.save(compradorDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompradorDTO> getById(@PathVariable Integer id) {
        CompradorDTO dto = compradorService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<CompradorDTO>> getAll() {
        return ResponseEntity.ok(compradorService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompradorDTO> update(@PathVariable Integer id, @RequestBody CompradorDTO compradorDTO) {
        return ResponseEntity.ok(compradorService.update(id, compradorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        compradorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
