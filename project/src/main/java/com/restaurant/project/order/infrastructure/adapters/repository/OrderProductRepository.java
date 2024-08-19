package com.restaurant.project.order.infrastructure.adapters.repository;

import com.restaurant.project.order.infrastructure.adapters.entity.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProductEntity,Long> {
}
