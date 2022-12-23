package com.asl.intern.survey.service;

import com.asl.intern.survey.dto.OptionsDTO;

import java.util.List;

public interface OptionsService {
    List<OptionsDTO> findByQuestionId(Integer questionId);
    void deleteOption(Integer optionId);
}
