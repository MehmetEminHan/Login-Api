package com.han.loginapi.services.sessions;

import com.han.loginapi.model.User;
import com.han.loginapi.repository.UserEntity;
import com.han.loginapi.repository.UserRepository;
import com.han.loginapi.services.generators.Md5;
import com.han.loginapi.services.mapper.UsersMapper;
import org.springframework.stereotype.Service;


@Service
public class UserLogin {

    private final UserRepository userRepository;
    UsersMapper mapper = UsersMapper.INSTANCE;

    public UserLogin(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(User user) {

        if (user.getEmail() != null) {

            return loginCheck(user, user.getEmail());

        } else if (user.getUserName() != null) {

            return loginCheck(user, user.getUserName());

        } else {

            return false;

        }

    }

    private boolean loginCheck(User incomingDto, String value) {

        User filteredDTO = mapper.EntityToDto(userRepository.findByUserNameOrEmail(value));

        if (filteredDTO != null && filteredDTO.getPassword().equals(Md5.getMd5(incomingDto.getPassword()))) {
            UserEntity userEntity = userRepository.findByUserNameOrEmail(value);
            userEntity.setIsLogin(true);
            userRepository.save(userEntity);
            return true;
        }

        return false;
    }

}
