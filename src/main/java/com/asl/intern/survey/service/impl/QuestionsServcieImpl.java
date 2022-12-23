package com.asl.intern.survey.service.impl;

import com.asl.intern.survey.dto.OptionsDTO;
import com.asl.intern.survey.dto.QuestionsDTO;
import com.asl.intern.survey.dto.Survey;
import com.asl.intern.survey.po.Options;
import com.asl.intern.survey.po.Questions;
import com.asl.intern.survey.repository.OptionsRepository;
import com.asl.intern.survey.repository.QuestionsRepository;
import com.asl.intern.survey.service.QuestionsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionsServcieImpl implements QuestionsService {
    @Autowired
    private QuestionsRepository questionsRepository;
    @Autowired
    private OptionsRepository optionsRepository;
    @Override
    public List<Survey> getSurvey() {
        List<Questions> questionsList = questionsRepository.findByEnabled(1);
        List<Survey> surveyList = questionsList.stream().map(questions -> {
            System.out.println(questions);
            Survey survey = new Survey();
            BeanUtils.copyProperties(questions,survey);
            System.out.println(survey);
            Integer questionsId = questions.getQuestionId();
            List<Options> optionsList = optionsRepository.findByQuestionIdOrderBySequence(questionsId);
            List<OptionsDTO> optionDTOList = optionsList.stream().map(options -> {
                OptionsDTO optionDTO = new OptionsDTO();
                BeanUtils.copyProperties(options,optionDTO);
                return optionDTO;
            }).collect(Collectors.toList());
            survey.setOptions(optionDTOList);
            return survey;
        }).collect(Collectors.toList());
        return surveyList;
    }

    @Override
    public List<QuestionsDTO> getQuestions() {
        List<Questions> questionsList = questionsRepository.findByOrderBySequence();
        List<QuestionsDTO> questionsDTOList = questionsList.stream().map(questions -> {
            System.out.println(questions);
            QuestionsDTO questionsDTO = new QuestionsDTO();
            BeanUtils.copyProperties(questions,questionsDTO);
            System.out.println(questionsDTO);
            Integer questionsId = questions.getQuestionId();
            List<Options> optionsList = optionsRepository.findByQuestionIdOrderBySequence(questionsId);
            List<OptionsDTO> optionDTOList = optionsList.stream().map(options -> {
                OptionsDTO optionDTO = new OptionsDTO();
                BeanUtils.copyProperties(options,optionDTO);
                return optionDTO;
            }).collect(Collectors.toList());
            questionsDTO.setOptions(optionDTOList);
            return questionsDTO;
        }).collect(Collectors.toList());
        return questionsDTOList;
    }

    @Override
    public QuestionsDTO enabledQuestion(QuestionsDTO questionsDTO) {
        Integer questionId = questionsDTO.getQuestionId();
        Questions question = questionsRepository.getById(questionId);
        BeanUtils.copyProperties(questionsDTO,question);
        question.setUpdateTime(new Date());
        questionsRepository.save(question);
        return questionsDTO;
    }

    @Override
    public QuestionsDTO saveQuestion(QuestionsDTO questionsDTO) {
        Questions question = new Questions();
        BeanUtils.copyProperties(questionsDTO,question);
        question.setEnabled(1);
        question.setCreateTime(new Date());
        question.setUpdateTime(new Date());
        Questions savedQuestion = questionsRepository.save(question);
        Integer questionId = savedQuestion.getQuestionId();
        questionsDTO.setQuestionId(questionId);

        List<OptionsDTO> optionsDTOList = questionsDTO.getOptions();
        optionsDTOList.stream().map(optionsDTO -> {
            Options option = new Options();
            BeanUtils.copyProperties(optionsDTO,option);
            option.setCreateTime(new Date());
            option.setUpdateTime(new Date());
            option.setQuestionId(questionId);
            optionsRepository.save(option);
            return optionsDTO;
        }).collect(Collectors.toList());

        return questionsDTO;
    }
    @Override
    public QuestionsDTO updateQuestion(QuestionsDTO questionsDTO) {
        Integer questionId = questionsDTO.getQuestionId();
        Questions question = questionsRepository.getById(questionId);
        BeanUtils.copyProperties(questionsDTO,question);
        question.setUpdateTime(new Date());
        questionsRepository.save(question);

        List<OptionsDTO> optionsDTOList = questionsDTO.getOptions();
        optionsDTOList.stream().map(optionsDTO -> {
            Options option = new Options();
            BeanUtils.copyProperties(optionsDTO,option);
            option.setUpdateTime(new Date());
            if(option.getCreateTime()==null ){
                option.setCreateTime(new Date());
                option.setQuestionId(questionId);
            }
            optionsRepository.save(option);
            return optionsDTO;
        }).collect(Collectors.toList());

        return questionsDTO;
    }

    @Override
    public QuestionsDTO getQuestionById(int questionId) {
        Questions question = questionsRepository.findById(questionId).get();
        QuestionsDTO questionsDTO = new QuestionsDTO();
        BeanUtils.copyProperties(question,questionsDTO);
        List<Options> optionsList = optionsRepository.findByQuestionIdOrderBySequence(questionId);
        List<OptionsDTO> optionsDTOList = optionsList.stream().map(options -> {
            OptionsDTO optionsDTO = new OptionsDTO();
            BeanUtils.copyProperties(options,optionsDTO);
            return optionsDTO;
        }).collect(Collectors.toList());
        questionsDTO.setOptions(optionsDTOList);
        return questionsDTO;
    }


}
