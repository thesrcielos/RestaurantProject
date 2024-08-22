package com.restaurant.project.product.infrastructure.adapters.mapper;

import com.restaurant.project.product.domain.model.Combo;
import com.restaurant.project.product.domain.model.ComboProduct;
import com.restaurant.project.product.domain.model.Product;
import com.restaurant.project.product.infrastructure.adapters.entity.ComboProductEntity;
import com.restaurant.project.product.infrastructure.adapters.entity.ProductEntity;

public interface ProductInfraMapper {
    ProductEntity productToEntity(Product product);
    Product entityToProduct(ProductEntity productEntity);
    ProductEntity comboToEntity(Combo combo);
    Combo entityToCombo(ProductEntity combo);
    ComboProduct entityToComboProduct(ComboProductEntity entity);
    ComboProductEntity comboProductToEntity(ComboProduct comboProduct, Combo combo);
}
