package com.example.restapi.Task.Repository;

import com.example.restapi.Task.Model.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public class TaskRepo extends CrudRepository<TaskEntity, Long> {
}
