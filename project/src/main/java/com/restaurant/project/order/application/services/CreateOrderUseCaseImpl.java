package com.restaurant.project.order.application.services;

import com.restaurant.project.client.domain.model.Client;
import com.restaurant.project.client.domain.ports.ClientPersistencePort;
import com.restaurant.project.order.application.dto.OrderProductRequest;
import com.restaurant.project.order.application.dto.OrderRequest;
import com.restaurant.project.order.application.dto.OrderResponse;
import com.restaurant.project.order.application.mapper.OrderAppMapper;
import com.restaurant.project.order.application.usecases.CreateOrderUseCase;
import com.restaurant.project.order.domain.model.Order;
import com.restaurant.project.order.domain.model.OrderProduct;
import com.restaurant.project.order.domain.ports.OrderPersistencePort;
import com.restaurant.project.product.domain.model.Product;
import com.restaurant.project.product.domain.ports.ProductPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {
    private final OrderPersistencePort orderPersistencePort;
    private final ClientPersistencePort clientPersistencePort;
    private final ProductPersistencePort productPersistencePort;
    private final OrderAppMapper orderMapper;

    public OrderResponse createOrder(OrderRequest orderRequest){
        Client client = clientPersistencePort.getById(orderRequest.getClientId());
        Order order = new Order();
        order.setClient(client);

        List<OrderProductRequest> orderProductRequests = orderRequest.getOrderProductRequests();
        if (orderProductRequests == null){
            throw new RuntimeException("The order doesn't have any order product");
        }
        List<OrderProduct> orderProducts = orderProductRequests.stream()
                .map(this::createOrderProductObject)
                .toList();

        order.setOrderProducts(orderProducts);
        order.calculateOrderTotal();
        order.setDate(LocalDateTime.now());
        Order orderSaved = orderPersistencePort.save(order);
        return orderMapper.toOrderResponse(orderSaved);
    }

    @Override
    public OrderProduct createOrderProductObject(OrderProductRequest request){
        Product product = productPersistencePort.getById(request.getProductId());
        Integer quantity = request.getQuantity();
        if (quantity==null || quantity<1){
            throw new RuntimeException("Error Order quantity with product id: " + product.getId()+"name: "+product.getName() +" and quantity "+quantity);
        }
        return new OrderProduct(null,product,quantity);
    }
}
