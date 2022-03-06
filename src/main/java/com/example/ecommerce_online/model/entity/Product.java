package com.example.ecommerce_online.model.entity;

import com.example.ecommerce_online.model.enums.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_product")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product implements Serializable {
    @Id
    Long id;
    @Column(nullable = false, length = 50)
    String name;
    @Column(nullable = false, length = 100)
    String description;
    @Column(nullable = false, length = 50)
    String suitableFor;
    @Column(nullable = false, length = 50)
    String usage;
    @Column(nullable = false, length = 50)
    String consistOf;
    @Column(nullable = false, length = 20)
    String volume;
    @ManyToOne
    @JoinColumn(name = "category")
    Category category;
    @ManyToOne
    @JoinColumn(name = "price")
    Price price;
    @ManyToOne
    @JoinColumn(name = "discount")
    Discount discount;
    @ManyToOne
    @JoinColumn(name = "inventory")
    Inventory inventory;
    @Enumerated(EnumType.STRING)
    @Column(name = "product_status")
    ProductStatus productStatus;
    @NotBlank
    String image;
    @CreationTimestamp
    LocalDateTime dateCreated;
    @PositiveOrZero
    BigDecimal discountedPrice;
}
