package com.asl.intern.survey.utils;

import com.asl.intern.survey.Exception.ServiceException;
import com.asl.intern.survey.common.BaseResponse;
import com.asl.intern.survey.common.ResultCode;
import com.asl.intern.survey.dto.AdminDTO;
import com.asl.intern.survey.po.Admin;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import javax.xml.crypto.Data;
import java.util.*;

public class JwtUtil implements HandlerInterceptor {

    public static String createToken(AdminDTO admin){

        Map<String,Object> map = new HashMap<>();
        map.put("alg","HMAC256");
        map.put("typ","JWT");
        Date nowDate = new Date();
        Date expireDate = getAfterDate(nowDate,0,0,0,1,0,0);
        String token = JWT.create()
                .withHeader(map)
                .withClaim("username",admin.getUsername())
                .withJWTId(UUID.randomUUID().toString())
                .withIssuer("SERVICE")
                .withSubject("login token")
                .withAudience(String.valueOf(admin.getAdminId()))
                .withIssuedAt(nowDate)
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256("!@#$SLF12GD"));
        return token;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServiceException {
        String token = request.getHeader("token");
        if(verify(token)){
            return true;
        }else {
            return false;
        }
    }

    public static Boolean verify(String token) throws ServiceException {
        if (token==null){
            return false;
        }
        JWTVerifier build = JWT.require(Algorithm.HMAC256("!@#$SLF12GD")).build();
        DecodedJWT verify = null;
        try {
            verify = build.verify(token);
        } catch (Exception e) {
            throw new ServiceException(ResultCode.LOGIN_SUCCESS.getCode(), ResultCode.LOGIN_SUCCESS.getMessage());
        }

//        Map<String, Claim> claims = verify.getClaims();
            return true;
    }


    public static Date getAfterDate(Date date, int year, int month, int day, int hour, int minute, int second){
        if(date == null){
            date = new Date();
        }

        Calendar cal = new GregorianCalendar();

        cal.setTime(date);
        if(year != 0){
            cal.add(Calendar.YEAR, year);
        }
        if(month != 0){
            cal.add(Calendar.MONTH, month);
        }
        if(day != 0){
            cal.add(Calendar.DATE, day);
        }
        if(hour != 0){
            cal.add(Calendar.HOUR_OF_DAY, hour);
        }
        if(minute != 0){
            cal.add(Calendar.MINUTE, minute);
        }
        if(second != 0){
            cal.add(Calendar.SECOND, second);
        }
        return cal.getTime();
    }
}
