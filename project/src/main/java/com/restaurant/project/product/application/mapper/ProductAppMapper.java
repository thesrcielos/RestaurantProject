package com.restaurant.project.product.application.mapper;

import com.restaurant.project.product.application.dto.ProductRequest;
import com.restaurant.project.product.application.dto.ProductResponse;
import com.restaurant.project.product.domain.model.Product;

public interface ProductAppMapper {
    Product requestToProduct(ProductRequest request);

    ProductResponse toProductResponse(Product product);

}
