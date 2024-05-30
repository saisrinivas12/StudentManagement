package com.student.StudentManagement.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Requested Id not found on the server");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}

