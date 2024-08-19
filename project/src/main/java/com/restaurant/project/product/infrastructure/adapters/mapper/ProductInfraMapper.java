package com.restaurant.project.product.infrastructure.adapters.mapper;

import com.restaurant.project.product.domain.model.Product;
import com.restaurant.project.product.infrastructure.adapters.entity.ProductEntity;

public interface ProductInfraMapper {
    ProductEntity productToEntity(Product product);
    Product entityToProduct(ProductEntity productEntity);
}
