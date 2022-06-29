package com.han.loginapi.services.login.impl;

import com.han.loginapi.model.UserDTO;
import com.han.loginapi.repository.UserEntity;
import com.han.loginapi.repository.UserRepository;
import com.han.loginapi.services.login.UserLogin;
import com.han.loginapi.services.mapper.UsersMapper;
import com.han.loginapi.services.generators.Md5;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserLoginImpl implements UserLogin {

    private final UserRepository userRepository;
    UsersMapper mapper = UsersMapper.INSTANCE;

    public UserLoginImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public boolean login(UserDTO userDTO) {

        if (userDTO.getEmail() != null) {

            return loginCheck(userDTO, userDTO.getEmail());

        } else if (userDTO.getUserName() != null) {

            return loginCheck(userDTO, userDTO.getUserName());

        } else {

            return false;

        }

    }

    private boolean loginCheck(UserDTO incomingDto, String value) {

        UserDTO filteredDTO = mapper.EntityToDto(userRepository.findByUserNameOrEmail(value));

        if (filteredDTO != null && filteredDTO.getPassword().equals(Md5.getMd5(incomingDto.getPassword()))) {
            UserEntity userEntity = userRepository.findByUserNameOrEmail(incomingDto.getEmail());
            userEntity.setIsLogin(true);
            userRepository.save(userEntity);
            return true;
        }

        return false;
    }

}
