package com.michilatte.ecomarket.api;

import com.michilatte.ecomarket.dto.EmpresaDTO;
import com.michilatte.ecomarket.model.Empresa;
import com.michilatte.ecomarket.repository.EmpresaRepository;
import com.michilatte.ecomarket.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@RequiredArgsConstructor
public class EmpresaRestController {
    private final EmpresaService empresaService;

    @GetMapping("/lista")
    public List<EmpresaDTO> getAll() {
        return empresaService.getAllEmpresas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> getById(@PathVariable Integer id) {
        return empresaService.getEmpresaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmpresaDTO> create(@RequestBody Empresa empresa) {
        return new ResponseEntity<>(empresaService.createEmpresa(empresa), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDTO> update(@PathVariable Integer id, @RequestBody Empresa empresa) {
        try {
            return ResponseEntity.ok(empresaService.updateEmpresa(id, empresa));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        empresaService.deleteEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}

