package com.example.ecommerce_online.service.impl;

import com.example.ecommerce_online.mapper.ProductMapper;
import com.example.ecommerce_online.model.entity.Product;
import com.example.ecommerce_online.model.entity.Role;
import com.example.ecommerce_online.repository.RoleRepo;
import com.example.ecommerce_online.service.RoleService;
import com.example.ecommerce_online.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role create(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public List<Role> getAll() {
        return roleRepo.findAll();
    }

    @Override
    public Role get(String name) {
        return roleRepo.findByName(name).orElseThrow(() -> new NotFoundException("not found by name:" + name));
    }

    @Override
    public Role update(Role role) {
        return roleRepo.findByName(role.getName()).map(role1 -> {
            if (role.getName() == "string" || role.getName() == null) {
                role1.setName(role1.getName());
            } else {
                role1.setName(role.getName());
            }
            role1.setAuthority(role.getAuthority());
            roleRepo.save(role1);
            return role1;
        }).orElseThrow(() -> new NotFoundException("not found by name: " + role.getName()));
    }

    @Override
    public Role delete(String name) {
        Role role = roleRepo.findByName(name)
                .orElseThrow(() -> new NotFoundException("not found by name:" + name + " not found or already deleted"));

        roleRepo.delete(role);
        return role;
    }
}
