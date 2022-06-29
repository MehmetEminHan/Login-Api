package com.han.loginapi.services.register.impl;

import com.han.loginapi.model.UserDTO;
import com.han.loginapi.repository.UserEntity;
import com.han.loginapi.repository.UserRepository;
import com.han.loginapi.services.generators.Md5;
import com.han.loginapi.services.mapper.UsersMapper;
import com.han.loginapi.services.register.UserRegister;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserRegisterImpl implements UserRegister {

    private final UserRepository userRepository;
    UsersMapper mapper = UsersMapper.INSTANCE;

    public UserRegisterImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(UUID.randomUUID().toString());
        userEntity.setPassword(Md5.getMd5(userDTO.getPassword()));
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setEmail(userDTO.getEmail());
        userRepository.save(userEntity);
    }
}
