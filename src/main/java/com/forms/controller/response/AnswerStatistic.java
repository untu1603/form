package com.forms.controller.response;

import com.forms.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;


@Data @AllArgsConstructor
public class AnswerStatistic {
    List<List<String>> formAnswers;
    int total;
//    Map<Integer,List<QuestionStatistic>> questions;
//    @Data
//    public static class QuestionStatistic{
//        List<Integer> choices;
//        List<String> contents;
//    }
}
