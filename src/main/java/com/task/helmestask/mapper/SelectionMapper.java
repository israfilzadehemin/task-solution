package com.task.helmestask.mapper;

import com.task.helmestask.dto.SelectionResponseDto;
import com.task.helmestask.entity.Selection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class SelectionMapper {

    public static final SelectionMapper INSTANCE = Mappers.getMapper(SelectionMapper.class);

    @Mapping(source = "selectionId", target = "id")
    public abstract SelectionResponseDto mapToResponseDto(Selection product);
}
