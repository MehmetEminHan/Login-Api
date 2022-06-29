package com.han.loginapi.services.mapper;

import com.han.loginapi.model.User;
import com.han.loginapi.repository.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UsersMapper {
    public static UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

    public abstract UserEntity DtoToEntity(User user);
    public abstract User EntityToDto(UserEntity userEntity);




}
