package com.example.ecommerce_online.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class UpdateUserRequest {
    @NotBlank
    String firstName;

    @NotBlank
    String lastName;

    @Email
    String email;

    @NotBlank
    @Size(min = 9, max = 13)
    String phoneNumber;

    @NotBlank
    @Length(min = 0, max = 50, message = "Invalid address credentials")
    String address;

    @NotBlank
    @Size(min = 16, max = 16)
    String paymentDetails;

    Long role;

    @NotBlank
    String login;

    @NotBlank
    @JsonIgnore
    String password;
}
