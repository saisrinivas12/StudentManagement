package com.student.StudentManagement.dto;

public class JWTResponse {


    private String jwtToken;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    @Override
    public String toString() {
        return "JWTResponse{" +
                "jwtToken='" + jwtToken + '\'' +
                '}';
    }
}
