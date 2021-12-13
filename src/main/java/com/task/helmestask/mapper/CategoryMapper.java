package com.task.helmestask.mapper;

import com.task.helmestask.dto.CategoryResponseDto;
import com.task.helmestask.entity.Category;
import java.util.stream.Collectors;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {

    public static final CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);


    @Mapping(source = "selectionId", target = "id")
    @Mapping(target = "subcategories", ignore = true)
    public abstract CategoryResponseDto mapToResponseDto(Category category);

    @AfterMapping
    void setSubCategories(@MappingTarget CategoryResponseDto.CategoryResponseDtoBuilder<?, ?> response, Category category) {
        response.subcategories(
                category.getSubcategories()
                        .stream()
                        .map(SubcategoryMapper.INSTANCE::mapToResponseDto)
                        .collect(Collectors.toList()));

    }
}
