package com.example.ecommerce_online.model.request;

import com.example.ecommerce_online.model.entity.Product;
import com.example.ecommerce_online.model.entity.User;
import com.example.ecommerce_online.service.dto.ProductDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class CreateOrderRequest {

    @NotNull
    Long user;

    @NotNull
    List<ProductDto> products;

    @NotNull
            @PositiveOrZero
    Long totalPrice;

}
