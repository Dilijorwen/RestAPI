package com.example.restapi.Task.Service;

import com.example.restapi.Task.Entity.TodoEntity;
import com.example.restapi.Task.Entity.UserEntity;
import com.example.restapi.Task.Model.Todo;
import com.example.restapi.Task.Repository.TodoRepo;
import com.example.restapi.Task.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo complete(Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
