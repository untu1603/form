package com.forms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

}
