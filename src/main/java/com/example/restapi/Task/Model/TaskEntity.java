package com.example.restapi.Task.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity // Создает БД с полями
@Data // Заменяет get и set
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean status;

    // указываем, что поле юзера в задачах связано с id их юзера
    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity user;
}
