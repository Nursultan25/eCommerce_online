package com.example.ecommerce_online.service.dto;

import com.example.ecommerce_online.model.entity.Order;
import com.example.ecommerce_online.model.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDto {
    Long id;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String address;
    String paymentDetails;
    List<Order> orderList;
}
