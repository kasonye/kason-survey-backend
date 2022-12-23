package com.asl.intern.survey.controller;

import com.asl.intern.survey.common.BaseResponse;
import com.asl.intern.survey.common.ResultCode;
import com.asl.intern.survey.dto.QuestionsDTO;
import com.asl.intern.survey.service.OptionsService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/survey-api/options")
public class OptionsController {
    @Autowired
    private OptionsService optionsService;

    @DeleteMapping
    @RequestMapping("/{id}")
    public BaseResponse deleteOrder(@PathVariable int id){
        try {
            optionsService.deleteOption(id);
        } catch (EmptyResultDataAccessException e) {
            return new BaseResponse(ResultCode.DELETED_FAIL.getCode(), ResultCode.DELETED_FAIL.getMessage());
        }
        return new BaseResponse(ResultCode.DELETED_SUCCESS.getCode(), ResultCode.DELETED_SUCCESS.getMessage());
    }

}
