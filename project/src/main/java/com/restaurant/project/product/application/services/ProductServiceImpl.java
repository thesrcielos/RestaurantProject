package com.restaurant.project.product.application.services;

import com.restaurant.project.product.application.dto.ProductRequest;
import com.restaurant.project.product.application.dto.ProductResponse;
import com.restaurant.project.product.application.mapper.ProductAppMapper;
import com.restaurant.project.product.application.usecases.ProductService;
import com.restaurant.project.product.domain.model.Product;
import com.restaurant.project.product.domain.ports.ProductPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductAppMapper productMapper;
    private final ProductPersistencePort persistencePort;

    @Override
    public ProductResponse save(ProductRequest request) {
        var product = productMapper.requestToProduct(request);
        return productMapper.toProductResponse(persistencePort.save(product));
    }

    @Override
    public void deleteProductById(Long id) {
        persistencePort.deleteById(id);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return productMapper.toProductResponse(persistencePort.getById(id));
    }
    @Override
    public List<ProductResponse> getAllProducts() {
        return persistencePort.getAll().stream()
                .map(productMapper::toProductResponse)
                .toList();
    }

    @Override
    public ProductResponse updateProductDetails(Long id, ProductRequest request) {
        Product product = productMapper.requestToProduct(request);
        product.setId(id);
        return productMapper.toProductResponse(persistencePort.update(product));
    }
}
