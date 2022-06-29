package com.han.loginapi.repository;

import com.han.loginapi.model.UserDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query("SELECT x FROM UserEntity x WHERE x.email=?1 OR x.userName=?1")
    UserEntity findByUserNameOrEmail(String userInfo);

}
