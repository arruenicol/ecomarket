package com.michilatte.ecomarket.repository;

import com.michilatte.ecomarket.model.Empresa;
import com.michilatte.ecomarket.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    List<Empresa> findByNombreContainingIgnoreCase(String nombre);
    List<Empresa> findByVendedorIdVendedor(Integer idVendedor);
    @Query("SELECT e FROM Empresa e JOIN e.vendedor v WHERE v.idVendedor = :idVendedor")
    Optional<Empresa> findVendedorAndEmpresaByIdVendedor(@Param("idVendedor") Integer idVendedor);

}
