package com.asl.intern.survey.controller;

import com.asl.intern.survey.common.BaseResponse;
import com.asl.intern.survey.common.ResultCode;
import com.asl.intern.survey.dto.QuestionsDTO;
import com.asl.intern.survey.dto.Survey;
import com.asl.intern.survey.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("survey-api/questions")
public class QuestionsController {
    @Autowired
    private QuestionsService questionsService;

    @GetMapping
    public BaseResponse<List<QuestionsDTO>> getQuestions(){
        return new BaseResponse<>(ResultCode.FIND_SUCESS.getCode(),ResultCode.FIND_SUCESS.getMessage(),questionsService.getQuestions());
    }

    @PutMapping
    @RequestMapping("/enabled")
    public BaseResponse<QuestionsDTO> enabledQuestion(@RequestBody QuestionsDTO questions){
        return new BaseResponse<>(ResultCode.MODIFIED_SUCCESS.getCode(), ResultCode.MODIFIED_SUCCESS.getMessage(), questionsService.enabledQuestion(questions));
    }

    @PostMapping
    public BaseResponse<QuestionsDTO> saveQuestion(@RequestBody QuestionsDTO questions){
        return new BaseResponse<>(ResultCode.ADD_SUCCESS.getCode(), ResultCode.ADD_SUCCESS.getMessage(), questionsService.saveQuestion(questions));
    }

    @GetMapping("{id}")
    public BaseResponse<QuestionsDTO> getQuestionById(@PathVariable("id") int questionId){
        return new BaseResponse<>(ResultCode.FIND_SUCESS.getCode(), ResultCode.FIND_SUCESS.getMessage(), questionsService.getQuestionById(questionId));
    }
    @PutMapping
    public BaseResponse<QuestionsDTO> updateQuestion(@RequestBody QuestionsDTO questions){
        return new BaseResponse<>(ResultCode.MODIFIED_SUCCESS.getCode(), ResultCode.MODIFIED_SUCCESS.getMessage(), questionsService.updateQuestion(questions));
    }

}
