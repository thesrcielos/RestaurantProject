package com.restaurant.project.order.application.mapper;

import com.restaurant.project.annotations.Mapper;
import com.restaurant.project.client.application.dto.ClientResponse;
import com.restaurant.project.client.application.mapper.ClientAppMapper;
import com.restaurant.project.order.application.dto.OrderProductResponse;
import com.restaurant.project.order.application.dto.OrderResponse;
import com.restaurant.project.order.domain.model.Order;
import com.restaurant.project.order.domain.model.OrderProduct;
import com.restaurant.project.product.application.dto.ProductResponse;
import com.restaurant.project.product.application.mapper.ProductAppMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Mapper
@RequiredArgsConstructor
public class OrderAppMapperImpl implements OrderAppMapper{
    private final ProductAppMapper productAppMapper;
    private final ClientAppMapper clientAppMapper;
    @Override
    public OrderResponse toOrderResponse(Order order) {
        List<OrderProductResponse> orderProductsResponse = order.getOrderProducts()
                .stream()
                .map(this::toOrderProductResponse)
                .toList();
        ClientResponse client = clientAppMapper.toClientResponse(order.getClient());
        return OrderResponse.builder()
                .id(order.getId())
                .client(client)
                .orderProducts(orderProductsResponse)
                .total(order.getTotal())
                .date(order.getDate())
                .build();
    }

    @Override
    public OrderProductResponse toOrderProductResponse(OrderProduct orderProduct) {
        ProductResponse productResponse = productAppMapper.toProductResponse(orderProduct.getProduct());
        return new OrderProductResponse(orderProduct.getId(),productResponse,orderProduct.getQuantity());
    }
}
