package com.michilatte.ecomarket.repository;

import com.michilatte.ecomarket.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer> {

    @Query("SELECT c FROM Carrito c JOIN c.comprador co WHERE co.idComprador = :carritoComprador")
    List<Carrito> findByComprador(@Param("carritoComprador") Integer carritoComprador);


}
