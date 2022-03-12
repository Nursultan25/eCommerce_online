package com.example.ecommerce_online.model.request;

import com.example.ecommerce_online.model.enums.ProductStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class UpdateProductRequest {
    Long id;
    String name;
    String description;
    String suitableFor;
    String usage;
    String consistOf;
    String volume;
    String brand;
    ProductStatus productStatus;
    Long category;
    Long price;
    Long discount;
    Long inventory;
    String image;
}
