package com.example.products.Mapper;

import com.example.products.Dto.ProductDto;
import com.example.products.Entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto modelToDto(ProductEntity productEntity);

    List<ProductDto> modelsToDtos(List<ProductEntity> productEntities);

    @InheritInverseConfiguration
    ProductEntity dtoToModel(ProductDto productDto);

}
