package com.han.loginapi.services.sessions;

import com.han.loginapi.model.User;
import com.han.loginapi.repository.UserEntity;
import com.han.loginapi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserLogout {

    private final UserRepository userRepository;

    public UserLogout(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void userLogout(User user) {

        UserEntity userEntity = userRepository.findByUserNameOrEmail(user.getEmail());
        userEntity.setIsLogin(false);
        userRepository.save(userEntity);

    }

}
