package com.restaurant.project.order.application.usecases;

import com.restaurant.project.order.application.dto.OrderProductRequest;
import com.restaurant.project.order.application.dto.OrderRequest;
import com.restaurant.project.order.application.dto.OrderResponse;
import com.restaurant.project.order.domain.model.Order;
import com.restaurant.project.order.domain.model.OrderProduct;

public interface CreateOrderUseCase {
    OrderResponse createOrder(OrderRequest request);
    OrderProduct createOrderProductObject(OrderProductRequest request);
}
