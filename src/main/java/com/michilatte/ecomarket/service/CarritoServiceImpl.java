package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.model.Carrito;
import com.michilatte.ecomarket.repository.CarritoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CarritoServiceImpl implements CarritoService {

    private final CarritoRepository carritoRepository;

    @Override
    public Carrito findById(Integer id) {
        return carritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado con ID: " + id));
    }

    @Override
    public List<Carrito> findAll() {
        return carritoRepository.findAll();
    }

    @Override
    public Carrito save(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public void deleteById(Integer id) {
        carritoRepository.deleteById(id);
    }

    @Override
    public List<Carrito> findByCompradorId(Integer idComprador) {
        return carritoRepository.findByComprador(idComprador);
    }
}