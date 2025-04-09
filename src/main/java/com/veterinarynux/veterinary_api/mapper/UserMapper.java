package com.veterinarynux.veterinary_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.veterinarynux.veterinary_api.model.User;
import com.veterinarynux.veterinary_api.model.dto.UserDto;
import com.veterinarynux.veterinary_api.service.AuthService;

@Mapper
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserDto toDto(User user);

  User toEntity(UserDto userDto);

  AuthService toUserDetails(User user);
}
