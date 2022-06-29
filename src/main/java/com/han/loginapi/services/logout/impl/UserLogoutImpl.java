package com.han.loginapi.services.logout.impl;

import com.han.loginapi.model.UserDTO;
import com.han.loginapi.repository.UserEntity;
import com.han.loginapi.repository.UserRepository;
import com.han.loginapi.services.logout.UserLogout;
import org.springframework.stereotype.Service;

@Service
public class UserLogoutImpl implements UserLogout {

    private final UserRepository userRepository;

    public UserLogoutImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void userLogout(UserDTO userDTO) {

        UserEntity userEntity = userRepository.findByUserNameOrEmail(userDTO.getEmail());
        userEntity.setIsLogin(false);
        userRepository.save(userEntity);

    }

}
