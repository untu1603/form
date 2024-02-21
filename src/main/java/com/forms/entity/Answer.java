package com.forms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "answer_id", nullable = false)
    private UUID answerId;

    @Column(name = "form_id", nullable = false)
    private UUID formId;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "contents", columnDefinition = "json", nullable = false)
    private String contents;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_updated_time", nullable = false)
    private LocalDateTime lastUpdatedTime;
}
