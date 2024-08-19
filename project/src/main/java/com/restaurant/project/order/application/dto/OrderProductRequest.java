package com.restaurant.project.order.application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductRequest {
    @NotNull(message = "product id must not be null")
    @Positive(message = "product id must be greater than 0")
    Long productId;
    @NotNull(message = "product quantity cant be null")
    @Positive(message = "product quantity must be greater than 0")
    Integer quantity;
}
