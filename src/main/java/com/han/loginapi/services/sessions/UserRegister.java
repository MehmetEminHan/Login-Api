package com.han.loginapi.services.sessions;

import com.han.loginapi.model.User;
import com.han.loginapi.repository.UserEntity;
import com.han.loginapi.repository.UserRepository;
import com.han.loginapi.services.generators.Md5;
import com.han.loginapi.services.mapper.UsersMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserRegister {

    private final UserRepository userRepository;
    UsersMapper mapper = UsersMapper.INSTANCE;

    public UserRegister(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(UUID.randomUUID().toString());
        userEntity.setPassword(Md5.getMd5(user.getPassword()));
        userEntity.setUserName(user.getUserName());
        userEntity.setEmail(user.getEmail());
        userRepository.save(userEntity);
    }
}
