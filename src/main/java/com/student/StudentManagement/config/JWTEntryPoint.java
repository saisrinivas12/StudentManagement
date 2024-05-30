package com.student.StudentManagement.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class JWTEntryPoint  implements AuthenticationEntryPoint {
    private static final Logger log = LoggerFactory.getLogger(JWTEntryPoint.class);
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        PrintWriter writer = response.getWriter();
        writer.println("Exception has occurred while authenticating the user using JWT "+authException.getMessage());
        log.error("Authentication Exception has occurred while authenticating the user ");
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.sendError(HttpStatus.FORBIDDEN.value(),"Cannot Authenticate User Details Please Try Again !!");
    }
}
