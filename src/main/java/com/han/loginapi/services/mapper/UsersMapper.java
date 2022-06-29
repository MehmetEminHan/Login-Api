package com.han.loginapi.services.mapper;

import com.han.loginapi.model.UserDTO;
import com.han.loginapi.repository.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ObjectFactory;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public abstract class UsersMapper {
    public static UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

    public abstract UserEntity DtoToEntity(UserDTO userDTO);
    public abstract UserDTO EntityToDto(UserEntity userEntity);




}
