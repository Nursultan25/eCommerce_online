package com.example.ecommerce_online.service.dto;

import com.example.ecommerce_online.model.entity.Category;
import com.example.ecommerce_online.model.entity.Discount;
import com.example.ecommerce_online.model.entity.Inventory;
import com.example.ecommerce_online.model.entity.Price;
import com.example.ecommerce_online.model.enums.ProductStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {
    Long id;
    String name;
    String description;
    String suitableFor;
    String usage;
    String consistOf;
    String volume;
    String brand;
    ProductStatus productStatus;
    Category category;
    Price price;
    Discount discount;
    Inventory inventory;
    String image;
    @JsonIgnore
    LocalDateTime dateCreated;
    BigDecimal discountedPrice;
}
