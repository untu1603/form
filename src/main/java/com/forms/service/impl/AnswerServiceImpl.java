package com.forms.service.impl;

import com.forms.controller.response.AnswerStatistic;
import com.forms.entity.Answer;
import com.forms.entity.Question;
import com.forms.repository.AnswerRepository;
import com.forms.repository.FormRepository;
import com.forms.service.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service @Slf4j
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final FormRepository formRepository;

    @Override
    public Answer create(Answer answer) {
        answer.setCreatedDate(LocalDateTime.now());
        answer.setLastUpdatedTime(LocalDateTime.now());
        return answerRepository.save(answer);
    }

    @Override
    public AnswerStatistic statistic(UUID formId) {
        List<Question> questions = formRepository.findById(formId).orElseThrow().getQuestions();
        List<Answer> answers= answerRepository.findAllByFormId(formId);
        List<List<String>> listAnswer = new ArrayList<>();
        List<String> row = new ArrayList<>();
//        List<AnswerStatistic.QuestionStatistic> questionStatisticList = new ArrayList<>(questions.size());
//        createMemory(questions,questionStatisticList);
        listAnswer.add(questions.stream().map(Question::getContent).toList());
        answers.forEach(answer -> {
            for (int i = 0; i < questions.size() ; i++) {
                 var question = questions.get(i);

                 if (question.getType()==1){
                     String choice = answer.getContents().get(i).getMultipleChoice();
//                     totalChoices(questionStatisticList,i, choice);
                     row.add(answer.getContents().get(i).getMultipleChoice());
                 }
                 if (question.getType()==2){
                     row.add(answer.getContents().get(i).getCheckBox().toString());
                }
                if (question.getType()==3){
                    row.add(answer.getContents().get(i).getParagraph());
                }
                if (i== questions.size()-1) {
                    listAnswer.add(new ArrayList<>(row));
                    row.clear();
                }
            }
        });
        return new AnswerStatistic(listAnswer,answers.size());
    }
    private Map<String,Integer> mapChoices(List<String> choices)
    {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < choices.size() ; i++) {
            map.put(choices.get(i), i);
        }
        return map;
    }
//    private void totalChoices( List<AnswerStatistic.QuestionStatistic> questionStatisticList,Integer id, String choice)
//    {
//        questionStatisticList.get(id).getChoices()
//    }
//    private void createMemory(List<Question> questions, List<AnswerStatistic.QuestionStatistic> questionStatisticList)
//    {
//        for (int i = 0; i < questions.size() ; i++) {
//            questionStatisticList.get(i).setChoices(new ArrayList<>(questions.get(i).getChoices().size()));
//        }
//    }
}
