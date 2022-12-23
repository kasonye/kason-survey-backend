package com.asl.intern.survey.repository;

import com.asl.intern.survey.po.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions,Integer> {
    List<Questions> findByEnabled(Integer enabled);
    List<Questions> findByOrderBySequence();
}
