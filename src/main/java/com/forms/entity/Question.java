package com.forms.entity;

import lombok.Data;

import java.util.List;

@Data
public class Question {
    private String type;
    private String content;
    private List<String> choices;
}
