package com.restaurant.project.product.application.usecases;

import com.restaurant.project.product.application.dto.ComboRequest;
import com.restaurant.project.product.application.dto.ComboResponse;
import com.restaurant.project.product.application.dto.ProductRequest;
import com.restaurant.project.product.application.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse updateProductDetails(Long id,ProductRequest request);
    ProductResponse getProductById(Long id);
    List<ProductResponse> getAllProducts();
    void deleteProductById(Long id);
    ProductResponse save(ProductRequest request);
    ComboResponse save(ComboRequest request);

}
