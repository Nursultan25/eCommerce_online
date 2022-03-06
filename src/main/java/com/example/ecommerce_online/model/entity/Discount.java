package com.example.ecommerce_online.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_discount")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Discount implements Serializable {
    @Id
    Long id;
    @PositiveOrZero
    @Min(0)
    @Max(100)
    Byte discount;
    @CreationTimestamp
    LocalDateTime startDate;
    LocalDateTime endDate;
}
