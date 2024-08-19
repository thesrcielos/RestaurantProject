package com.restaurant.project.order.domain.model;

import com.restaurant.project.client.domain.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private Client client;
    private LocalDateTime date;
    private List<OrderProduct> orderProducts;
    private BigDecimal total;

    public BigDecimal calculateOrderTotal(){
        total = BigDecimal.ZERO;
        for (OrderProduct orderProduct: orderProducts){
            BigDecimal orderProductTotal = orderProduct.calculateTotal();
            total = total.add(orderProductTotal);
        }
        total = total.setScale(2, RoundingMode.HALF_DOWN);
        return total;
    }
}
