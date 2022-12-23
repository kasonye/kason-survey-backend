package com.asl.intern.survey.repository;

import com.asl.intern.survey.dto.RecordsDTO;
import com.asl.intern.survey.po.Records;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Records,Integer> {
    List<Records> findByOrderByCreateTime();
}
