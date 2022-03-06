package com.example.ecommerce_online.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

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
}
