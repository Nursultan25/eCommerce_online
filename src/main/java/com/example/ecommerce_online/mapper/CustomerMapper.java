package com.example.ecommerce_online.mapper;

import com.example.ecommerce_online.model.entity.Customer;
import com.example.ecommerce_online.service.dto.CustomerDto;
import com.example.ecommerce_online.model.entity.User;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public class CustomerMapper implements BaseMapper<CustomerDto, Customer> {
    private MapperFacade mapperFacade;

    public CustomerMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(CustomerDto.class, User.class)
                .byDefault();

        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public Customer toEntity(CustomerDto dto) {
        return mapperFacade.map(dto, Customer.class);
    }

    @Override
    public CustomerDto toDto(Customer entity) {
        return mapperFacade.map(entity, CustomerDto.class);
    }

    @Override
    public List<Customer> toEntities(List<CustomerDto> dtoList) {
        return dtoList.stream().map(x -> mapperFacade.map(x, Customer.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> toDtoList(List<Customer> entities) {
        return entities.stream().map(x -> mapperFacade.map(entities, CustomerDto.class))
                .collect(Collectors.toList());
    }
}
