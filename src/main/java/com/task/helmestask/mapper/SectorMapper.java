package com.task.helmestask.mapper;

import com.task.helmestask.dto.SectorResponseDto;
import com.task.helmestask.entity.Sector;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
@AllArgsConstructor
public abstract class SectorMapper {

    public static final SectorMapper INSTANCE = Mappers.getMapper(SectorMapper.class);

    @Mapping(source = "selectionId", target = "id")
    @Mapping(target = "categories", ignore = true)
    public abstract SectorResponseDto mapToResponseDto(Sector sector);

    @AfterMapping
    void setCategories(@MappingTarget SectorResponseDto.SectorResponseDtoBuilder<?, ?> response, Sector sector) {
        response.categories(
                sector.getCategories()
                        .stream()
                        .map(CategoryMapper.INSTANCE::mapToResponseDto)
                        .collect(Collectors.toList()));

    }
}
