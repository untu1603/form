package com.forms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID formId;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "questions", columnDefinition = "json", nullable = false)
    private String questions;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_updated_time", nullable = false)
    private LocalDateTime lastUpdatedTime;
}