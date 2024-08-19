package com.restaurant.project.order.domain.ports;

import com.restaurant.project.order.domain.model.Order;

import java.util.List;

public interface OrderPersistencePort {
    Order save(Order order);
    Order update(Order order);
    void deleteById(Long id);
    Order getById(Long id);
    List<Order> getByClientId(Long id);
    List<Order> getAll();
}
