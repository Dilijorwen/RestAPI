package com.example.restapi.Task.Service;

import com.example.restapi.Task.DTO.UserWithoutPasswordDTO;
import com.example.restapi.Task.Exception.UserAlreadyExistException;
import com.example.restapi.Task.Exception.UserCanNotBeDeleted;
import com.example.restapi.Task.Exception.UserNotFoundException;
import com.example.restapi.Task.Model.UserEntity;
import com.example.restapi.Task.Repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public UserEntity registartion(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует >:(");
        }
        return userRepo.save(user);
    }

    public UserWithoutPasswordDTO getOne(Long id) throws UserNotFoundException {
        Optional<UserEntity> user = userRepo.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("Пользователь не найден");
        }
        return modelMapper.map(user, UserWithoutPasswordDTO.class);
    }

    public UserWithoutPasswordDTO delete(Long id) throws UserCanNotBeDeleted {
        Optional<UserEntity> user = userRepo.findById(id);
        userRepo.deleteById(id);
        if(user.isEmpty()){
            throw new UserCanNotBeDeleted("Пользователь не может быть удален, так как не найден");
        }
        return modelMapper.map(user, UserWithoutPasswordDTO.class);
    }

    public UserEntity update(UserEntity user, Long id) throws UserNotFoundException{
        UserEntity newUser = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Пользователь не был найден"));
        if(newUser.getUsername() != null){
            newUser.setUsername(user.getUsername());
        }
        if(newUser.getPassword() != null){
            newUser.setPassword(user.getPassword());
        }
        return newUser;
    }
}
