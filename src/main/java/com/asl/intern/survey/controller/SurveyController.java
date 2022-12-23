package com.asl.intern.survey.controller;

import com.asl.intern.survey.common.BaseResponse;
import com.asl.intern.survey.common.ResultCode;
import com.asl.intern.survey.dto.Survey;
import com.asl.intern.survey.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("survey-api/survey")
public class SurveyController {
    @Autowired
    private QuestionsService questionsService;

    @GetMapping
    public BaseResponse<List<Survey>> getSurvey(){
        return new BaseResponse<>(ResultCode.FIND_SUCESS.getCode(),ResultCode.FIND_SUCESS.getMessage(),questionsService.getSurvey());
    }
}
