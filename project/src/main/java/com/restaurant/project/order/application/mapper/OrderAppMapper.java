package com.restaurant.project.order.application.mapper;

import com.restaurant.project.order.application.dto.OrderProductResponse;
import com.restaurant.project.order.application.dto.OrderResponse;
import com.restaurant.project.order.domain.model.Order;
import com.restaurant.project.order.domain.model.OrderProduct;

public interface OrderAppMapper {
    OrderResponse toOrderResponse(Order order);
    OrderProductResponse toOrderProductResponse(OrderProduct orderProduct);
}
