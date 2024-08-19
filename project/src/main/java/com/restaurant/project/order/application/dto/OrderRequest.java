package com.restaurant.project.order.application.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    @NotNull(message = "client id must not be null")
    @Positive(message = "client id must be greater than 0")
    private Long clientId;
    @NotEmpty(message = "List of product order requests cant be empty")
    @Valid
    private List<OrderProductRequest> orderProductRequests;
}
