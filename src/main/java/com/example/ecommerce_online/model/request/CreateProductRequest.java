package com.example.ecommerce_online.model.request;

import com.example.ecommerce_online.model.entity.Category;
import com.example.ecommerce_online.model.entity.Discount;
import com.example.ecommerce_online.model.entity.Inventory;
import com.example.ecommerce_online.model.entity.Price;
import com.example.ecommerce_online.model.enums.ProductStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class CreateProductRequest {
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
