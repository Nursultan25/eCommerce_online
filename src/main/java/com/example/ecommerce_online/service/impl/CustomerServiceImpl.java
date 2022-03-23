package com.example.ecommerce_online.service.impl;

import com.example.ecommerce_online.mapper.CustomerMapper;
import com.example.ecommerce_online.model.entity.Customer;
import com.example.ecommerce_online.model.request.CreateCustomerRequest;
import com.example.ecommerce_online.model.request.UpdateCustomerRequest;
import com.example.ecommerce_online.repository.CustomerRepo;
import com.example.ecommerce_online.service.CustomerService;
import com.example.ecommerce_online.service.dto.CustomerDto;
import com.example.ecommerce_online.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;
    private CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public CustomerDto register(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setAddress(request.getAddress());
        customer.setPaymentDetails(request.getPaymentDetails());
        return customerMapper.toDto(customerRepo.save(customer));
    }

    @Override
    public List<CustomerDto> getAll() {
        return customerMapper.toDtoList(customerRepo.findAll());
    }

    @Override
    public CustomerDto get(Long id) {
        return customerMapper.toDto(customerRepo.findById(id).orElseThrow(() -> new NotFoundException("Did not find user by id")));
    }

    @Override
    public CustomerDto update(UpdateCustomerRequest request) {
        return null;
    }

    @Override
    public CustomerDto delete(Long id) {
        return null;
    }
}
