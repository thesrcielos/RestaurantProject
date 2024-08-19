package com.restaurant.project.product.domain.ports;

import com.restaurant.project.product.domain.model.Product;

import java.util.List;

public interface ProductPersistencePort {
    Product save(Product product);
    Product update(Product product);
    void deleteById(Long id);
    List<Product> getAll();
    Product getById(Long id);
}
