package com.michilatte.ecomarket.repository;

import com.michilatte.ecomarket.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
    List<Vendedor> findByNombre(String nombre);

    @Query("SELECT v FROM Empresa e JOIN e.vendedor v WHERE v.idVendedor = :idVendedor")
    Optional<Vendedor> findVendedorAndEmpresaByIdVendedor(@Param("idVendedor") Integer idVendedor);


}