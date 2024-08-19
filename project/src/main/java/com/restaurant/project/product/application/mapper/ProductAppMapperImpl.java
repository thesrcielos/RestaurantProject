package com.restaurant.project.product.application.mapper;

import com.restaurant.project.annotations.Mapper;
import com.restaurant.project.product.application.dto.ProductRequest;
import com.restaurant.project.product.application.dto.ProductResponse;
import com.restaurant.project.product.domain.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Mapper
public class ProductAppMapperImpl implements ProductAppMapper{

    private final ModelMapper modelMapper;
    public ProductAppMapperImpl(){
        modelMapper = new ModelMapper();
    }
    @Override
    public Product requestToProduct(ProductRequest request) {
        return modelMapper.map(request,Product.class);
    }

    @Override
    public ProductResponse toProductResponse(Product product) {
        return modelMapper.map(product,ProductResponse.class);
    }

}
