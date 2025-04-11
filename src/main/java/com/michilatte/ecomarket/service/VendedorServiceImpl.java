package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.model.Vendedor;
import com.michilatte.ecomarket.repository.VendedorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class VendedorServiceImpl implements VendedorService {

    private final VendedorRepository vendedorRepository;

    @Override
    public List<Vendedor> getAllVendedores() {
        return vendedorRepository.findAll();
    }

    @Override
    public Optional<Vendedor> getVendedorById(Integer id) {
        return vendedorRepository.findById(id);
    }

    @Override
    public Vendedor createVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    @Override
    public Vendedor updateVendedor(Integer id, Vendedor vendedor) {
        return vendedorRepository.findById(id).map(existing -> {
            existing.setNombre(vendedor.getNombre());
            existing.setApellido(vendedor.getApellido());
            existing.setTipoDoc(vendedor.getTipoDoc());
            existing.setNumIdentificador(vendedor.getNumIdentificador());
            existing.setFechaNacimiento(vendedor.getFechaNacimiento());
            existing.setTelefono(vendedor.getTelefono());
            existing.setCorreo(vendedor.getCorreo());
            existing.setContrasenia(vendedor.getContrasenia());
            return vendedorRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
    }

    @Override
    public void deleteVendedor(Integer id) {
        vendedorRepository.deleteById(id);
    }
}