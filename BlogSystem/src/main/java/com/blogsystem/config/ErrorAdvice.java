package com.blogsystem.config;


import com.blogsystem.model.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler
    public Result errorHandler(Exception e) {
        return Result.fail(e.getMessage());
    }
}
