package com.example.ecommerce_online.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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
@Builder
@Table(name = "tb_discount")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Discount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @PositiveOrZero
    @Min(0)
    @Max(100)
    Integer discount;
    @JsonIgnore
    @CreationTimestamp
    LocalDateTime startDate;
    @JsonIgnore
    LocalDateTime endDate;
}
