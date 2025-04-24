package com.michilatte.ecomarket.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.michilatte.ecomarket.dto.EmpresaDTO;
import com.michilatte.ecomarket.dto.VendedorDTO;
import com.michilatte.ecomarket.model.Vendedor;
import com.michilatte.ecomarket.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vendedores")
@RequiredArgsConstructor
public class VendedorRestController {

    private final VendedorService vendedorService;


    @GetMapping("/lista")
    public List<VendedorDTO> getAll() {
        return vendedorService.getAllVendedores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorDTO> getById(@PathVariable Integer id) {
        return vendedorService.getVendedorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<VendedorDTO> create(@RequestBody Map<String, Object> body) {
        // Deserialize manually using ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        VendedorDTO vendedorDTO = mapper.convertValue(body.get("vendedor"), VendedorDTO.class);
        EmpresaDTO empresaDTO = mapper.convertValue(body.get("empresa"), EmpresaDTO.class);

        VendedorDTO created = vendedorService.createVendedor(vendedorDTO, empresaDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<VendedorDTO> update(@PathVariable Integer id, @RequestBody VendedorDTO vendedorDTO) {
        try {
            VendedorDTO updated = vendedorService.updateVendedor(id, vendedorDTO);
            return ResponseEntity.ok(updated);
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

