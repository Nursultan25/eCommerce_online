package com.example.ecommerce_online.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_inventory")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Inventory implements Serializable {
    @Id
    Long id;
    @PositiveOrZero
    Long quantity;
    Boolean inStock;
}
