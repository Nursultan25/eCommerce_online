package com.example.ecommerce_online.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "first_name", nullable = false, length = 50)
    String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    String lastName;
    @Column(unique = true, length = 50, nullable = false)
    @Email
    String email;
    @Column(name = "phone_number", length = 15)
    String phoneNumber;
    String address;
    @Column(name = "payment_details")
    String paymentDetails;
    @OneToMany
    List<Order> orderList;
    @ManyToOne
    @JoinColumn(name = "role")
    Role role;
    @Column(unique = true)
    String login;
    String password;
}
