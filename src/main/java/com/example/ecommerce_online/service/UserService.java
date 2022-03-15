package com.example.ecommerce_online.service;

import com.example.ecommerce_online.model.request.CreateUserRequest;
import com.example.ecommerce_online.model.request.UpdateUserRequest;
import com.example.ecommerce_online.service.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDto register(CreateUserRequest request);

    List<UserDto> getAll();

    UserDto get(Long id);

    UserDto update(UpdateUserRequest request);

    UserDto delete(Long id);

}
