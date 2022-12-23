package com.asl.intern.survey.service;


import com.asl.intern.survey.dto.RecordsDTO;

import java.util.List;

public interface RecordsService {
    RecordsDTO saveRecords(RecordsDTO recordsDTO);
    List<RecordsDTO> getRecords();
}
