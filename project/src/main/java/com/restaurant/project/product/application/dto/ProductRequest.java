package com.restaurant.project.product.application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    @Size(min = 5, max = 50, message = "name length must be between 5 and 50")
    @NotNull(message = "name cant be null")
    private String name;
    @Size(min = 10, max = 300, message = "Description length must be between 10 and 300")
    @NotNull(message = "description cant be null")
    private String description;
    @Positive(message = "Price must be greater than 0")
    @NotNull(message = "price cant be null")
    private BigDecimal price;
    @Pattern(regexp = "^(http|https)://[^\\s$.?#].[^\\s]*$", message = "imageURL is not valid")
    @NotNull(message = "imageURL cant be null")
    private String imageURL;
}
