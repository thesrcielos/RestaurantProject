package com.restaurant.project.product.infrastructure.adapters.repository;

import com.restaurant.project.product.infrastructure.adapters.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
