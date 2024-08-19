package com.restaurant.project.order.infrastructure.adapters.mapper;

import com.restaurant.project.annotations.Mapper;
import com.restaurant.project.client.domain.model.Client;
import com.restaurant.project.client.infrastructure.adapters.entity.ClientEntity;
import com.restaurant.project.client.infrastructure.adapters.mapper.ClientInfraMapper;
import com.restaurant.project.order.domain.model.Order;
import com.restaurant.project.order.domain.model.OrderProduct;
import com.restaurant.project.order.infrastructure.adapters.entity.OrderEntity;
import com.restaurant.project.order.infrastructure.adapters.entity.OrderProductEntity;
import com.restaurant.project.product.application.mapper.ProductAppMapper;
import com.restaurant.project.product.domain.model.Product;
import com.restaurant.project.product.infrastructure.adapters.entity.ProductEntity;
import com.restaurant.project.product.infrastructure.adapters.mapper.ProductInfraMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@RequiredArgsConstructor
public class OrderInfraMapperImpl implements OrderInfraMapper {
    private final ProductInfraMapper productMapper;
    private final ClientInfraMapper clientInfraMapper;
    @Override
    public OrderEntity orderToEntity(Order order) {
        List<OrderProductEntity> orderProductEntities = order.getOrderProducts().stream()
                .map(this::orderProductToEntity)
                .toList();
        ClientEntity client = clientInfraMapper.toClientEntity(order.getClient());
        return new OrderEntity(null,client,order.getDate(),orderProductEntities,order.getTotal());
    }


    @Override
    public Order entityToOrder(OrderEntity orderEntity) {
        List<OrderProduct> orderProducts = orderEntity.getOrderProducts().stream()
                .map(this::entityToOrderProduct)
                .toList();
        Client client = clientInfraMapper.toClient(orderEntity.getClient());
        return new Order(orderEntity.getId(), client,orderEntity.getDate(),orderProducts,orderEntity.getTotal());
    }

    @Override
    public OrderProduct entityToOrderProduct(OrderProductEntity entity) {
        Product product = productMapper.entityToProduct(entity.getProduct());
        return new OrderProduct(entity.getId(), product,entity.getQuantity());
    }

    @Override
    public OrderProductEntity orderProductToEntity(OrderProduct orderProduct) {
        ProductEntity productEntity = productMapper.productToEntity(orderProduct.getProduct());
        return new OrderProductEntity(null,productEntity,null, orderProduct.getQuantity());
    }
}
