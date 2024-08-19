package com.restaurant.project.product.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComboProduct {
    private Product productInCombo;
    private Integer quantity;
}
