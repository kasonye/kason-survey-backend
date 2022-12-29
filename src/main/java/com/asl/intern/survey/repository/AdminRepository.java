package com.asl.intern.survey.repository;

import com.asl.intern.survey.po.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    public Admin findByUsername(String username);
}
