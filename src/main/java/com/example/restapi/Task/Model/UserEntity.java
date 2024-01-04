package com.example.restapi.Task.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "users") // Создает БД с полями
@Data // Заменяет get и set и construct
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
}