package com.restaurant.project.order.domain.model;

import com.restaurant.project.product.domain.model.Product;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {
    private Long id;
    private Product product;
    private Integer quantity;

    public BigDecimal calculateTotal(){
        if(product == null){
            throw new RuntimeException("Product is null in orderProduct with id " + id);
        }
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}
