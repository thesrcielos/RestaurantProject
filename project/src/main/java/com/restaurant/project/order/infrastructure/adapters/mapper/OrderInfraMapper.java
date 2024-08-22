package com.restaurant.project.order.infrastructure.adapters.mapper;

import com.restaurant.project.order.domain.model.Order;
import com.restaurant.project.order.domain.model.OrderProduct;
import com.restaurant.project.order.infrastructure.adapters.entity.OrderEntity;
import com.restaurant.project.order.infrastructure.adapters.entity.OrderProductEntity;

public interface OrderInfraMapper {
    OrderEntity orderToEntity(Order order);
    Order entityToOrder(OrderEntity orderEntity);
    OrderProduct entityToOrderProduct(OrderProductEntity entity);
    OrderProductEntity orderProductToEntity(OrderProduct orderProduct, OrderEntity entity);
}
