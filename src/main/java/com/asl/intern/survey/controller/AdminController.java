package com.asl.intern.survey.controller;


import com.asl.intern.survey.Exception.ServiceException;
import com.asl.intern.survey.common.BaseResponse;
import com.asl.intern.survey.common.ResultCode;
import com.asl.intern.survey.dto.AdminDTO;
import com.asl.intern.survey.dto.RecordsDTO;
import com.asl.intern.survey.po.Admin;
import com.asl.intern.survey.service.AdminService;
import com.asl.intern.survey.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/survey-api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping
    public BaseResponse login(@RequestBody AdminDTO adminDTO)  {

        AdminDTO admin = adminService.login(adminDTO);
        if (admin==null){
            return new BaseResponse<>(ResultCode.LOGIN_FAIL.getCode(), ResultCode.LOGIN_FAIL.getMessage(),admin);
        }else {
            return new BaseResponse<>(ResultCode.LOGIN_SUCCESS.getCode(), ResultCode.LOGIN_SUCCESS.getMessage(), admin);
        }

    }

}
