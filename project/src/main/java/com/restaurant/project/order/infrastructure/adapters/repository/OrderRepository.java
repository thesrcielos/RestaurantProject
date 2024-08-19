package com.restaurant.project.order.infrastructure.adapters.repository;

import com.restaurant.project.order.infrastructure.adapters.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    List<OrderEntity> findByClientId(Long id);
}
