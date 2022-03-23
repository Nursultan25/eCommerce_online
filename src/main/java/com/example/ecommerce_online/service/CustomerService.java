package com.example.ecommerce_online.service;

import com.example.ecommerce_online.model.request.CreateCustomerRequest;
import com.example.ecommerce_online.model.request.UpdateCustomerRequest;
import com.example.ecommerce_online.service.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    CustomerDto register(CreateCustomerRequest request);

    List<CustomerDto> getAll();

    CustomerDto get(Long id);

    CustomerDto update(UpdateCustomerRequest request);

    CustomerDto delete(Long id);

}
