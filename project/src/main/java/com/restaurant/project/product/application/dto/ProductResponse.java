package com.restaurant.project.product.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    protected Long id;
    protected String name;
    protected String description;
    protected BigDecimal price;
    protected String imageURL;
    protected boolean isCombo;
}
