package com.restaurant.project.product.infrastructure.adapters.entity;

import com.restaurant.project.product.domain.model.Combo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ComboProducts")
public class ComboProductEntity {

    @EmbeddedId
    private ComboProductId id;
    @OneToOne
    @MapsId("comboId")
    @JoinColumn(name = "combo_id")
    ComboEntity combo;
    @OneToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    ProductEntity product;

    private Integer quantity;
}
