package com.task.helmestask.mapper;

import com.task.helmestask.dto.SubcategoryResponseDto;
import com.task.helmestask.entity.Subcategory;
import java.util.stream.Collectors;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class SubcategoryMapper {

    public static final SubcategoryMapper INSTANCE = Mappers.getMapper(SubcategoryMapper.class);

    @Mapping(source = "selectionId", target = "id")
    @Mapping(target = "products", ignore = true)
    public abstract SubcategoryResponseDto mapToResponseDto(Subcategory subcategory);

    @AfterMapping
    void setProducts(@MappingTarget SubcategoryResponseDto.SubcategoryResponseDtoBuilder<?, ?> response,
                     Subcategory subcategory) {
        response.products(
                subcategory.getProducts()
                        .stream()
                        .map(ProductMapper.INSTANCE::mapToResponseDto)
                        .collect(Collectors.toList()));

    }
}
