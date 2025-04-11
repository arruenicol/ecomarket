package com.michilatte.ecomarket.repository;

import com.michilatte.ecomarket.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    List<Empresa> findByNombreContainingIgnoreCase(String nombre);
    List<Empresa> findByVendedorIdVendedor(Integer idVendedor);
}
