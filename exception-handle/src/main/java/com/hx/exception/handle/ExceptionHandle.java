package com.hx.exception.handle;

import com.hx.exception.bean.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ExceptionHandle {
    private static final Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler
    public String testError(ArithmeticException e, HttpServletRequest request) {
        log.error("出现了除零异常", e);
        request.setAttribute("javax.servlet.error.status_code", 500);
        request.setAttribute("code", 66);
        request.setAttribute("msg", "出现了除零异常");
        return "forward:/error";
    }
    
    @ExceptionHandler
    @ResponseBody
    public ResultBean ageError(AgeException e) {
        log.error("年龄异常");
        return ResultBean.error(Integer.parseInt(e.getCode()), e.getMessage());
    }
} 
