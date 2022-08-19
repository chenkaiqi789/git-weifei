package com.gec.hazardous.controller;

import com.gec.hazardous.utils.ResultBean;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyException {

    @ExceptionHandler({IncorrectCredentialsException.class, UnknownAccountException.class})
    public ResultBean handlerException1(Exception e) {
        ResultBean error = ResultBean.error();
        error.setMsg("账号或密码错误");
        return error;
    }

    @ExceptionHandler({AuthorizationException.class,UnauthorizedException.class})
    public ResultBean handlerException2(Exception e) {
        ResultBean error = ResultBean.error();
        error.setMsg("无权访问");
        return error;
    }
}
