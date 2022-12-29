package com.asl.intern.survey.Exception;

import com.asl.intern.survey.common.BaseResponse;
import com.asl.intern.survey.common.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 如果抛出的的是ServiceException，则调用该方法
     * @param se 业务异常
     * @return Result
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public BaseResponse handle(ServiceException se){
        return new BaseResponse(ResultCode.LOGIN_FAIL.getCode(), ResultCode.LOGIN_FAIL.getMessage());
    }

}
