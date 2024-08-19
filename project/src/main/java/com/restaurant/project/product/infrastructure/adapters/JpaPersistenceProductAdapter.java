package com.restaurant.project.product.infrastructure.adapters;

import com.restaurant.project.product.domain.model.Product;
import com.restaurant.project.product.domain.ports.ProductPersistencePort;
import com.restaurant.project.product.infrastructure.adapters.entity.ProductEntity;
import com.restaurant.project.product.infrastructure.adapters.mapper.ProductInfraMapper;
import com.restaurant.project.product.infrastructure.adapters.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaPersistenceProductAdapter implements ProductPersistencePort {
    private final ProductRepository productRepository;
    private final ProductInfraMapper productMapper;
    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productMapper.productToEntity(product);
        productRepository.save(productEntity);
        return productMapper.entityToProduct(productEntity);
    }

    @Override
    public Product update(Product product) {
        ProductEntity savedProductEntity = productRepository.findById(product.getId()).orElseThrow(()->new RuntimeException("Product with id "+ product.getId()+" not found."));
        savedProductEntity.setName(product.getName());
        savedProductEntity.setDescription(product.getDescription());
        savedProductEntity.setImageURL(product.getImageURL());
        savedProductEntity.setPrice(product.getPrice());
        productRepository.save(savedProductEntity);
        return productMapper.entityToProduct(savedProductEntity);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll().stream()
                .map(productMapper::entityToProduct)
                .collect(Collectors.toList());
    }

    @Override
    public Product getById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product with id "+id+" not found."));
        return productMapper.entityToProduct(productEntity);
    }

}
