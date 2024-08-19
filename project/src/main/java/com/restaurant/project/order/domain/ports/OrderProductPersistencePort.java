package com.restaurant.project.order.domain.ports;

import com.restaurant.project.order.domain.model.OrderProduct;

public interface OrderProductPersistencePort {
    OrderProduct save(OrderProduct orderProduct);
    OrderProduct update(OrderProduct orderProduct);
    void deleteById(Long id);

}
