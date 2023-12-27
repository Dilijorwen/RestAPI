package com.example.restapi.Task.Repository;

import com.example.restapi.Task.Model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public class UserRepo extends CrudRepository<UserEntity, Long> {

}
