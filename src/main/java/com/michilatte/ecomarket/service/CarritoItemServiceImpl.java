package com.michilatte.ecomarket.service;

import com.michilatte.ecomarket.model.CarritoItem;
import com.michilatte.ecomarket.repository.CarritoItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CarritoItemServiceImpl implements CarritoItemService {
    private final CarritoItemRepository repository;

    @Override public CarritoItem save(CarritoItem item) {
        return repository.save(item); }

    @Override public void delete(Integer id) {
        repository.deleteById(id); }
}
