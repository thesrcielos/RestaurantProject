package com.restaurant.project.order.infrastructure.adapters;

import com.restaurant.project.order.domain.exception.OrderException;
import com.restaurant.project.order.domain.model.Order;
import com.restaurant.project.order.domain.ports.OrderPersistencePort;
import com.restaurant.project.order.infrastructure.adapters.entity.OrderEntity;
import com.restaurant.project.order.infrastructure.adapters.mapper.OrderInfraMapper;
import com.restaurant.project.order.infrastructure.adapters.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JpaOrderAdapter implements OrderPersistencePort {
    private final OrderRepository orderRepository;
    private final OrderInfraMapper orderMapper;
    @Override
    public Order save(Order order) {
        OrderEntity entity = orderMapper.orderToEntity(order);
        orderRepository.save(entity);
        return orderMapper.entityToOrder(entity);
    }

    @Override
    public Order update(Order order) {
        OrderEntity entity = orderRepository.findById(order.getId()).orElseThrow(()-> new OrderException("Order with id "+order.getId()+" not found", 400));
        orderRepository.save(entity);
        return orderMapper.entityToOrder(entity);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order getById(Long id) {
        OrderEntity entity = orderRepository.findById(id).orElseThrow(()-> new OrderException("Order with id "+id+" not found",400));
        return orderMapper.entityToOrder(entity);
    }

    @Override
    public List<Order> getByClientId(Long id) {
        return orderRepository.findByClientId(id).stream()
                .map(orderMapper::entityToOrder)
                .toList();
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll().stream()
                .map(orderMapper::entityToOrder)
                .toList();
    }
}
