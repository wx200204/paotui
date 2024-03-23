package com.example.newsb.exception;

import com.example.newsb.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * @ExceptionHandler相当于controller的@RequestMapping
     * 如果抛出的的是ServiceException，则调用该方法
     * @param
     * @return
     */
    @ExceptionHandler(ServiceException.class)

    @ResponseBody
    //如果抛出的的是ServiceException，则自动调用该方法
    public Result handle(ServiceException se){

        return Result.error(se.getCode(),se.getMessage());
    }




}
