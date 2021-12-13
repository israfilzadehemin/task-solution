package com.task.helmestask.mapper;

import com.task.helmestask.dto.UserDto;
import com.task.helmestask.entity.User;
import java.util.stream.Collectors;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "selections", ignore = true)
    public abstract UserDto mapToResponseDto(User user);

    @AfterMapping
    void setSelections(@MappingTarget UserDto.UserDtoBuilder response, User user) {
        response.selections(
                user.getSelections()
                        .stream()
                        .map(SelectionMapper.INSTANCE::mapToResponseDto)
                        .collect(Collectors.toList()));
    }

}
