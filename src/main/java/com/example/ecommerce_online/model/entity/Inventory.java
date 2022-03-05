package com.example.ecommerce_online.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventory")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Inventory implements Serializable {
    @Id
    Long id;
    Long quantity;
    @Column(name = "in_stock")
    Boolean inStock;
}
