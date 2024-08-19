package com.restaurant.project.order.application.dto;

import com.restaurant.project.product.application.dto.ProductResponse;
import com.restaurant.project.product.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductResponse {
    private Long id;
    private ProductResponse product;
    private Integer quantity;
}
