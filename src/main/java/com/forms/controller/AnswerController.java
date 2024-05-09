package com.forms.controller;

import com.forms.controller.response.AnswerStatistic;
import com.forms.entity.Answer;
import com.forms.service.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor @Slf4j
@CrossOrigin("*")
public class AnswerController {
    private final AnswerService answerService;
    @PostMapping("")
    public Answer creat(@RequestBody Answer answer)
    {
        return answerService.create(answer);
    }
    @GetMapping("/statistic/{id}")
    public AnswerStatistic get(@PathVariable(value = "id") UUID formId)
    {
        return answerService.statistic(formId);
    }
}
