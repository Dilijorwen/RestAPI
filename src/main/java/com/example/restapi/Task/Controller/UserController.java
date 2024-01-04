package com.example.restapi.Task.Controller;


import com.example.restapi.Task.Exception.UserAlreadyExistException;
import com.example.restapi.Task.Exception.UserCanNotBeDeleted;
import com.example.restapi.Task.Exception.UserNotFoundException;
import com.example.restapi.Task.Model.UserEntity;
import com.example.restapi.Task.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity registartion(@RequestBody UserEntity user) {
        try {
            userService.registartion(user);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла неизвестная ошибка!!");
        }
    }

    @GetMapping("/all")
    public ResponseEntity checkServer(){
        try{
            return ResponseEntity.ok("Сервер запущен");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла неизвестная ошибка!!");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла неизвестная ошибка!!");
        }
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (UserCanNotBeDeleted e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла неизвестная ошибка!!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id,
                                     @RequestBody UserEntity user){
        try {
            return ResponseEntity.ok(userService.update(user, id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла неизвестная ошибка!!");
        }
    }
}
