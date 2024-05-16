package com.forms.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "form")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "form_id", nullable = false)
    private UUID formId;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "header")
    private String header;

    @Column(name = "description")
    private String description;

    @Column(name = "screen_shot")
    private String screenShot;
    @Type(JsonType.class)
    @Column(name = "questions",columnDefinition = "json")
    private List<Question> questions;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_updated_time", nullable = false)
    private LocalDateTime lastUpdatedTime;

}
