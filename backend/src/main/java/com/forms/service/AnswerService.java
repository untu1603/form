package com.forms.service;

import com.forms.controller.response.AnswerStatistic;
import com.forms.entity.Answer;

import java.util.UUID;

public interface AnswerService {
    Answer create(Answer answer);

    AnswerStatistic statistic(UUID formId);
}
