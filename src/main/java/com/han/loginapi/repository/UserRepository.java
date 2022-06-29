package com.han.loginapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query("SELECT x FROM UserEntity x WHERE x.email=?1 OR x.userName=?1")
    UserEntity findByUserNameOrEmail(String userInfo);

}
