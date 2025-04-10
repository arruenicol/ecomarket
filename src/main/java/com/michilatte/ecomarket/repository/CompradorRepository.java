package com.michilatte.ecomarket.repository;

import com.michilatte.ecomarket.model.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador, Integer> {
}
