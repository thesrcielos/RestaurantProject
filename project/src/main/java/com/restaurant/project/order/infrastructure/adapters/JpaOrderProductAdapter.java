package com.restaurant.project.order.infrastructure.adapters;

import com.restaurant.project.order.domain.model.OrderProduct;
import com.restaurant.project.order.domain.ports.OrderProductPersistencePort;
import com.restaurant.project.order.infrastructure.adapters.entity.OrderProductEntity;
import com.restaurant.project.order.infrastructure.adapters.mapper.OrderInfraMapper;
import com.restaurant.project.order.infrastructure.adapters.repository.OrderProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaOrderProductAdapter implements OrderProductPersistencePort {

    private final OrderProductRepository orderProductRepository;
    private final OrderInfraMapper orderMapper;
    @Override
    public OrderProduct save(OrderProduct orderProduct) {
        OrderProductEntity entity = orderMapper.orderProductToEntity(orderProduct);
        orderProductRepository.save(entity);
        return orderMapper.entityToOrderProduct(entity);
    }

    @Override
    public OrderProduct update(OrderProduct orderProduct) {
        Long id = orderProduct.getId();
        OrderProductEntity entity = orderProductRepository.findById(id).orElseThrow(()->new RuntimeException("OrderProduct with id "+id+" not found"));
        orderProductRepository.save(entity);
        return orderMapper.entityToOrderProduct(entity);
    }

    @Override
    public void deleteById(Long id) {
        orderProductRepository.deleteById(id);
    }
}
