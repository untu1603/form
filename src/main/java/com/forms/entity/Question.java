package com.forms.entity;

import lombok.Data;

import java.beans.Transient;
import java.util.List;

@Data
public class Question {
    private int type;
    private String regexExpression;
    private int size;
    private String content;
    private List<Choice> choices;
    @Data
    private static class Choice{
        private int id;
        private String content;
    }
}
