package com.forms.entity;

import lombok.Data;

import java.util.List;

@Data
public class ContentAnswer {
    List<String> checkBox;
    String multipleChoice;
    String paragraph;
}
