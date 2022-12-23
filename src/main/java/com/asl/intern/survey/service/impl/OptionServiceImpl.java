package com.asl.intern.survey.service.impl;

import com.asl.intern.survey.dto.OptionsDTO;
import com.asl.intern.survey.po.Options;
import com.asl.intern.survey.repository.OptionsRepository;
import com.asl.intern.survey.service.OptionsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OptionServiceImpl implements OptionsService {
    @Autowired
    private OptionsRepository optionsRepository;
    @Override
    public List<OptionsDTO> findByQuestionId(Integer questionId) {
        List<Options> optionsList = optionsRepository.findByQuestionIdOrderBySequence(questionId);
        List<OptionsDTO> optionDTOList = optionsList.stream().map(options -> {
            OptionsDTO optionDTO = new OptionsDTO();
            BeanUtils.copyProperties(options,optionDTO);
            return optionDTO;
        }).collect(Collectors.toList());
        return optionDTOList;
    }

    @Override
    public void deleteOption(Integer optionId) {
        optionsRepository.deleteById(optionId);
    }
}
