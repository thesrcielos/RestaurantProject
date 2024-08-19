package com.restaurant.project.order.application.services;

import com.restaurant.project.order.application.dto.OrderRequest;
import com.restaurant.project.order.application.dto.OrderResponse;
import com.restaurant.project.order.application.usecases.CreateOrderUseCase;
import com.restaurant.project.order.application.usecases.OrderService;
import com.restaurant.project.order.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final CreateOrderUseCase createOrderUseCase;
    @Override
    public OrderResponse createOrder(OrderRequest request) {
        return createOrderUseCase.createOrder(request);
    }
}
