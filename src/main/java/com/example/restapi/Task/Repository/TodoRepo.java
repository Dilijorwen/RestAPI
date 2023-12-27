package com.example.restapi.Task.Repository;

import com.example.restapi.Task.Entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
