package com.example.ecommerce_online.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_category")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotBlank
    String title;
    String description;
    @NotBlank
    String name;
    @NotBlank
    String image;
    @Column(columnDefinition = "boolean default true")
    Boolean active;
}
