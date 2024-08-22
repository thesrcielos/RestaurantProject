package com.restaurant.project.product.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Combo extends Product {
    public Combo(Long id, String name, String description, BigDecimal price, String imageURL, List<ComboProduct> productsInCombo){
        super(id,name,description,price,imageURL,true);
        this.productsInCombo = productsInCombo;
    }
    private List<ComboProduct> productsInCombo;
}
