package com.restaurant.project.product.application.mapper;

import com.restaurant.project.product.application.dto.*;
import com.restaurant.project.product.domain.model.Combo;
import com.restaurant.project.product.domain.model.ComboProduct;
import com.restaurant.project.product.domain.model.Product;

public interface ProductAppMapper {
    Product requestToProduct(ProductRequest request);

    ProductResponse toProductResponse(Product product);
    ComboResponse toComboResponse(Combo combo);
    ComboProductResponse toComboProductResponse(ComboProduct comboProduct);
}
