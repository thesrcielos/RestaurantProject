package com.restaurant.project.order.application.dto;

import com.restaurant.project.client.application.dto.ClientResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private ClientResponse client;
    private LocalDateTime date;
    private List<OrderProductResponse> orderProducts;
    private BigDecimal total;
}
