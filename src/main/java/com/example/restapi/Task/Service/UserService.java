package com.example.restapi.Task.Service;

import com.example.restapi.Task.Entity.UserEntity;
import com.example.restapi.Task.Exception.UserAlreadyExistException;
import com.example.restapi.Task.Exception.UserCannotBeDeleted;
import com.example.restapi.Task.Exception.UserNotFoundException;
import com.example.restapi.Task.Model.User;
import com.example.restapi.Task.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registrtion(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user ==  null){
            throw new UserNotFoundException("Пользователь с таким именем не найден");
        }
        return User.toModel(user);
    }

    public User delete(Long id) throws UserCannotBeDeleted {
        Optional<UserEntity> user = userRepo.findById(id);
        UserEntity userNotOptional = userRepo.findById(id).get();
        userRepo.deleteById(id);
        if(user.isEmpty()){
            throw new UserCannotBeDeleted("Пользователя с таким id не существует");
        }
        return User.toModel(userNotOptional);
    }
}
