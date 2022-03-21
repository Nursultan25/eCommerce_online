package com.example.ecommerce_online.service;

import com.example.ecommerce_online.model.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    Role create(Role role);

    List<Role> getAll();

    Role get(Long id);

    Role update(Role role);

    Role delete(Long id);

}
