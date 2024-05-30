package com.student.StudentManagement.handlers;


import com.student.StudentManagement.exceptions.DetailsMisMatchException;
import com.student.StudentManagement.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public Map<String,Object> handleResourceNotFound(Exception ex, HttpServletResponse response){
        Map<String,Object>result = new HashMap<>();
        result.put("result",ex.getMessage());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return result;
    }

    @ExceptionHandler(DetailsMisMatchException.class)
    public Map<String,Object>handleDetailsMisMatch(Exception ex,HttpServletResponse response){
        Map<String,Object>result = new HashMap<>();
        result.put("result",ex.getMessage());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return result;
    }
}
