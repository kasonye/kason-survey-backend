package com.asl.intern.survey.controller;


import com.alibaba.fastjson.JSONArray;
import com.asl.intern.survey.common.BaseResponse;
import com.asl.intern.survey.common.ResultCode;
import com.asl.intern.survey.dto.RecordsDTO;
import com.asl.intern.survey.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("survey-api/records")
public class RecordsController {
    @Autowired
    private RecordsService recordsService;

    @PostMapping
    public BaseResponse<RecordsDTO> saveRecords(@RequestBody RecordsDTO recordsDTO){
        return new BaseResponse<>(ResultCode.FIND_SUCESS.getCode(), ResultCode.FIND_SUCESS.getMessage(),recordsService.saveRecords(recordsDTO));
    }

    @GetMapping
    public BaseResponse<List<RecordsDTO>> getRecords(){
        return new BaseResponse<>(ResultCode.FIND_SUCESS.getCode(), ResultCode.FIND_SUCESS.getMessage(),recordsService.getRecords());
    }
}
