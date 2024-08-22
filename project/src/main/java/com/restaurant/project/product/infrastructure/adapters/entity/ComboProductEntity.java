package com.restaurant.project.product.infrastructure.adapters.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "ComboProducts")
public class ComboProductEntity {
    @EmbeddedId
    private ComboProductId id = new ComboProductId();
    @ManyToOne
    @MapsId("comboId")
    @JoinColumn(name = "combo_id")
    private ProductEntity combo;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    private Integer quantity;

}
