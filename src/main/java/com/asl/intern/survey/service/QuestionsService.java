package com.asl.intern.survey.service;


import com.asl.intern.survey.dto.QuestionsDTO;
import com.asl.intern.survey.dto.Survey;

import java.util.List;

public interface QuestionsService {
    List<Survey> getSurvey();
    List<QuestionsDTO> getQuestions();
    QuestionsDTO enabledQuestion(QuestionsDTO questionsDTO);
    QuestionsDTO saveQuestion(QuestionsDTO questionsDTO);
    QuestionsDTO getQuestionById(int questionId);
    QuestionsDTO updateQuestion(QuestionsDTO questionsDTO);
}
