package com.example.restapi.Task.Repository;

import com.example.restapi.Task.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    UserEntity findByPassword(String password);
}
