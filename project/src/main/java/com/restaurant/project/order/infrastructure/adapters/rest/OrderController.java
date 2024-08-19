package com.restaurant.project.order.infrastructure.adapters.rest;

import com.restaurant.project.order.application.dto.OrderRequest;
import com.restaurant.project.order.application.dto.OrderResponse;
import com.restaurant.project.order.application.usecases.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(@RequestBody OrderRequest request){
        return orderService.createOrder(request);
    }
}
