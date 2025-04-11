package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.model.Inventario;
import com.michilatte.ecomarket.repository.InventarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository inventarioRepository;


    @Override
    public List<Inventario> getAllInventarios() {
        return inventarioRepository.findAll();
    }

    @Override
    public Optional<Inventario> getInventarioById(Integer id) {
        return inventarioRepository.findById(id);
    }

    @Override
    public Inventario saveInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public Inventario updateInventario(Integer id, Inventario inventario) {
        return inventarioRepository.findById(id).map(existing -> {
            existing.setProducto(inventario.getProducto());
            existing.setEmpresa(inventario.getEmpresa());
            existing.setPrecio(inventario.getPrecio());
            existing.setCantidad(inventario.getCantidad());
            return inventarioRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
    }

    @Override
    public void deleteInventario(Integer id) {
        inventarioRepository.deleteById(id);
    }


    @Override public List<Inventario> findByProductoId(Integer id) {
        return inventarioRepository.findByProductoIdProducto(id); }

    @Override public List<Inventario> findByEmpresaId(Integer id) {
        return inventarioRepository.findByEmpresaIdEmpresa(id); }
}
