package com.restaurant.project.product.infrastructure.adapters.mapper;

import com.restaurant.project.annotations.Mapper;
import com.restaurant.project.product.domain.model.Product;
import com.restaurant.project.product.infrastructure.adapters.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Mapper
public class ProductInfraMapperImpl implements ProductInfraMapper {
    private final ModelMapper modelMapper;
    public ProductInfraMapperImpl(){
        modelMapper = new ModelMapper();
    }

    @Override
    public ProductEntity productToEntity(Product product) {
        return modelMapper.map(product,ProductEntity.class);
    }

    @Override
    public Product entityToProduct(ProductEntity productEntity) {
        return modelMapper.map(productEntity,Product.class);
    }
}
