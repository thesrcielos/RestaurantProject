package com.restaurant.project.product.application.mapper;

import com.restaurant.project.annotations.Mapper;
import com.restaurant.project.product.application.dto.*;
import com.restaurant.project.product.domain.model.Combo;
import com.restaurant.project.product.domain.model.ComboProduct;
import com.restaurant.project.product.domain.model.Product;
import com.restaurant.project.product.domain.ports.ProductPersistencePort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public class ProductAppMapperImpl implements ProductAppMapper{

    private final ModelMapper modelMapper;
    private final ProductPersistencePort productPersistencePort;
    public ProductAppMapperImpl(ProductPersistencePort productPersistencePort){
        this.productPersistencePort = productPersistencePort;
        modelMapper = new ModelMapper();
    }
    @Override
    public Product requestToProduct(ProductRequest request) {
        return modelMapper.map(request,Product.class);
    }

    @Override
    public ProductResponse toProductResponse(Product product) {
        return !product.isCombo() ? modelMapper.map(product,ProductResponse.class)
                :toComboResponse((Combo) product);
    }


    @Override
    public ComboResponse toComboResponse(Combo combo) {
        ComboResponse comboResponse = modelMapper.map(combo,ComboResponse.class);
        List<ComboProductResponse> comboProductResponses = combo.getProductsInCombo().stream()
                .map(this::toComboProductResponse)
                .toList();
        comboResponse.setProductsInCombo(comboProductResponses);
        return comboResponse;
    }

    @Override
    public ComboProductResponse toComboProductResponse(ComboProduct comboProduct) {
        ProductResponse productResponse = toProductResponse(comboProduct.getProductInCombo());
        return new ComboProductResponse(productResponse,comboProduct.getQuantity());
    }


}
