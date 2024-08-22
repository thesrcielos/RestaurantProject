package com.restaurant.project.product.infrastructure.adapters.mapper;

import com.restaurant.project.annotations.Mapper;
import com.restaurant.project.product.domain.model.Combo;
import com.restaurant.project.product.domain.model.ComboProduct;
import com.restaurant.project.product.domain.model.Product;
import com.restaurant.project.product.infrastructure.adapters.entity.ComboProductEntity;
import com.restaurant.project.product.infrastructure.adapters.entity.ProductEntity;
import org.modelmapper.ModelMapper;

import java.util.List;

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
        if (productEntity.isCombo()) return entityToCombo(productEntity);
        return modelMapper.map(productEntity,Product.class);
    }

    @Override
    public ProductEntity comboToEntity(Combo combo) {
        return modelMapper.map(combo, ProductEntity.class);
    }

    @Override
    public Combo entityToCombo(ProductEntity comboEntity) {
        Combo combo = modelMapper.map(comboEntity,Combo.class);
        if (comboEntity.getComboProducts() != null){
            List<ComboProduct> comboProducts = comboEntity.getComboProducts().stream()
                   .map(this::entityToComboProduct)
                    .toList();
            combo.setProductsInCombo(comboProducts);
        }
        return combo;
    }

    public ComboProductEntity comboProductToEntity(ComboProduct comboProduct, Combo combo){
        ProductEntity product = productToEntity(comboProduct.getProductInCombo());
        ProductEntity comboEntity = comboToEntity(combo);
        ComboProductEntity entity = new ComboProductEntity();
        entity.setProduct(product);
        entity.setQuantity(comboProduct.getQuantity());
        entity.setCombo(comboEntity);
        return entity;
    }

    public ComboProduct entityToComboProduct(ComboProductEntity entity){
        Product product = entityToProduct(entity.getProduct());
        return new ComboProduct(product,entity.getQuantity());
    }
}
