package com.student.StudentManagement.exceptions;

public class DetailsMisMatchException extends RuntimeException{

    public DetailsMisMatchException(){
        super("Details are mismatched please check and try again !!");
    }

    public DetailsMisMatchException(String message){
        super(message);
    }
}
