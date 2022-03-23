package com.example.ecommerce_online.mapper;

import com.example.ecommerce_online.service.dto.ProductDto;
import com.example.ecommerce_online.model.entity.Product;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public class ProductMapper implements BaseMapper<ProductDto, Product>{
    private MapperFacade mapperFacade;

    public ProductMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(ProductDto.class, Product.class)
                .byDefault();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public Product toEntity(ProductDto dto) {
        return mapperFacade.map(dto, Product.class);
    }

    @Override
    public ProductDto toDto(Product entity) {
        return mapperFacade.map(entity, ProductDto.class);
    }

    @Override
    public List<Product> toEntities(List<ProductDto> dtoList) {
        return dtoList.stream().map(
                x -> mapperFacade.map(x, Product.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> toDtoList(List<Product> entities) {
        return entities.stream()
                .map(x -> mapperFacade.map(x, ProductDto.class))
                .collect(Collectors.toList());
    }
}
