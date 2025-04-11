package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.model.Vendedor;

import java.util.List;
import java.util.Optional;

public interface VendedorService {
    List<Vendedor> getAllVendedores();
    Optional<Vendedor> getVendedorById(Integer id);
    Vendedor createVendedor(Vendedor vendedor);
    Vendedor updateVendedor(Integer id, Vendedor vendedor);
    void deleteVendedor(Integer id);
}
