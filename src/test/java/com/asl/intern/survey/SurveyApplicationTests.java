package com.asl.intern.survey;

import com.asl.intern.survey.po.Options;
import com.asl.intern.survey.repository.OptionsRepository;
import com.asl.intern.survey.repository.QuestionsRepository;
import com.asl.intern.survey.service.OptionsService;
import com.asl.intern.survey.service.QuestionsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SurveyApplicationTests {
    @Autowired
    private OptionsService optionsService;
    @Autowired
    private QuestionsService questionsService;

    @Test
    public void getSurvey(){
        optionsService.deleteOption(13);
    }

}
