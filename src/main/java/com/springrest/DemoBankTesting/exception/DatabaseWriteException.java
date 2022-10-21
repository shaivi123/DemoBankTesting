package com.springrest.DemoBankTesting.exception;

public class DatabaseWriteException extends RuntimeException{

    public DatabaseWriteException(String message){
        super(message);
    }
}
