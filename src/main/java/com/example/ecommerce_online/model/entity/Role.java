package com.example.ecommerce_online.model.entity;

import com.example.ecommerce_online.model.enums.Authority;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_role")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotBlank
    String name;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    List<Authority> authority;
}
