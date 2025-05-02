package com.michilatte.ecomarket.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.michilatte.ecomarket.dto.EmpresaDTO;
import com.michilatte.ecomarket.dto.VendedorDTO;
import com.michilatte.ecomarket.model.Empresa;
import com.michilatte.ecomarket.repository.EmpresaRepository;
import com.michilatte.ecomarket.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/empresas")
@RequiredArgsConstructor
public class EmpresaRestController {
    private final EmpresaService empresaService;

    @GetMapping("/lista")
    public List<EmpresaDTO> getAll() {
        return empresaService.getAllEmpresas();
    }

    @GetMapping("empresa/{id}")
    public ResponseEntity<EmpresaDTO> getById(@PathVariable Integer id) {
        return empresaService.getEmpresaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/nueva")
    public ResponseEntity<EmpresaDTO> create(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();

        VendedorDTO vendedorDTO = mapper.convertValue(body.get("vendedor"), VendedorDTO.class);
        EmpresaDTO empresaDTO = mapper.convertValue(body.get("empresa"), EmpresaDTO.class);

        EmpresaDTO empresa = empresaService.createEmpresa(empresaDTO, vendedorDTO);
        return new ResponseEntity<>(empresa, HttpStatus.CREATED);
    }

    @GetMapping("/empresa_vendedor/{idVendedor}")
    public ResponseEntity<EmpresaDTO> getVendedorAndEmpresaByIdVendedor(@PathVariable Integer idVendedor) {
        return empresaService.findVendedorAndEmpresaByIdVendedor(idVendedor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("editar/{id}")
    public ResponseEntity<EmpresaDTO> update(@PathVariable Integer id, @RequestBody EmpresaDTO empresaDTO) {
        try {
            return ResponseEntity.ok(empresaService.updateEmpresa(id, empresaDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        empresaService.deleteEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}

