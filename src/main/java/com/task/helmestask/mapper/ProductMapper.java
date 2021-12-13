package com.task.helmestask.mapper;

import com.task.helmestask.dto.ProductResponseDto;
import com.task.helmestask.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    public static final ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "selectionId", target = "id")
    public abstract ProductResponseDto mapToResponseDto(Product product);
}
