package com.michilatte.ecomarket.api;

import com.michilatte.ecomarket.dto.CategoriaDTO;
import com.michilatte.ecomarket.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaRestController {

    private final CategoriaService categoriaService;

    @PostMapping("/nuevo")
    public ResponseEntity<CategoriaDTO> create(@RequestBody CategoriaDTO categoriaDTO) {
        return ResponseEntity.ok(categoriaService.createCategoria(categoriaDTO));
    }

    @GetMapping("id/{id}")
    public ResponseEntity<CategoriaDTO> getById(@PathVariable Integer id) {
        return categoriaService.getCategoriaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/lista")
    public ResponseEntity<List<CategoriaDTO>> getAll() {
        return ResponseEntity.ok(categoriaService.getAllCategorias());
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO) {
        try {
            CategoriaDTO updated = categoriaService.updateCategoria(id, categoriaDTO);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        categoriaService.deleteCategoria(id);
        return new ResponseEntity<>("El producto ha sido eliminado", HttpStatus.OK);
    }
}