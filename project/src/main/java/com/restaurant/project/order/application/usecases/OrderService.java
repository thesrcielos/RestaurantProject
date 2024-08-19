package com.restaurant.project.order.application.usecases;


import com.restaurant.project.order.application.dto.OrderRequest;
import com.restaurant.project.order.application.dto.OrderResponse;
import com.restaurant.project.order.domain.model.Order;

public interface OrderService {
    OrderResponse createOrder(OrderRequest request);
}
