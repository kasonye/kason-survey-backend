package com.asl.intern.survey.repository;

import com.asl.intern.survey.po.Options;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionsRepository extends JpaRepository<Options,Integer> {

    List<Options> findByQuestionIdOrderBySequence(Integer questionId);
}
