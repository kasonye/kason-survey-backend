package com.asl.intern.survey.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.asl.intern.survey.dto.RecordsDTO;
import com.asl.intern.survey.dto.Survey;
import com.asl.intern.survey.po.Records;
import com.asl.intern.survey.repository.RecordRepository;
import com.asl.intern.survey.service.RecordsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordsServiceImpl implements RecordsService {
    @Autowired
    private RecordRepository recordRepository;
    @Override
    public RecordsDTO saveRecords(RecordsDTO recordsDTO) {
        String recordData =JSONArray.toJSONString(recordsDTO.getSurveyList());
        Records record = new Records();
        BeanUtils.copyProperties(recordsDTO,record);
        record.setCreateTime(new Date());
        record.setRecordData(recordData);
        Records newRecord = recordRepository.save(record);
        Integer recordId = newRecord.getRecordId();
        recordsDTO.setRecordId(recordId);
        return recordsDTO;
    }

    @Override
    public List<RecordsDTO> getRecords() {
        List<Records> recordsList = recordRepository.findByOrderByCreateTime();
        List<RecordsDTO> recordsDTOList = recordsList.stream().map(record -> {
            RecordsDTO recordsDTO = new RecordsDTO();
            String recordData = record.getRecordData();
            List<Survey> surveyList = JSONObject.parseArray(recordData,Survey.class);
            BeanUtils.copyProperties(record,recordsDTO);
            recordsDTO.setSurveyList(surveyList);
            return recordsDTO;
        }).collect(Collectors.toList());
        return recordsDTOList;
    }
}
