package com.example.ecommerce_online.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_order")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order implements Serializable {
    @Id
    Long id;
    @ManyToOne
    @JoinColumn(name = "user")
    User user;
    @ManyToMany
    @JoinTable(
            name = "product_orders",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    List<Product> productList;
    @Column(name = "total_price", nullable = false)
    @PositiveOrZero
    Long totalPrice;
    @Column(name = "date_created", nullable = false)
    @CreationTimestamp
    Date dateCreated;
}
