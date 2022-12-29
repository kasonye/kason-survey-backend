package com.asl.intern.survey.service.impl;

import com.asl.intern.survey.dto.AdminDTO;
import com.asl.intern.survey.po.Admin;
import com.asl.intern.survey.repository.AdminRepository;
import com.asl.intern.survey.service.AdminService;
import com.asl.intern.survey.utils.JwtUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public AdminDTO login(AdminDTO adminDTO) {

        Admin admin = adminRepository.findByUsername(adminDTO.getUsername());
        if (admin==null){
            return null;
        }else{
            adminDTO.setAdminId(admin.getAdminId());
            String username = admin.getUsername();
            String password = admin.getPassword();

            if (adminDTO.getUsername().equals(username) && adminDTO.getPassword().equals(password)){
                adminDTO.setToken(JwtUtil.createToken(adminDTO));
                return adminDTO;
            }else {
                return null;
            }
        }

    }
}
