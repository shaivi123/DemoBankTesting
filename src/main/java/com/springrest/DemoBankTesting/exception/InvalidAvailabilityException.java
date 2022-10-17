package com.springrest.DemoBankTesting.exception;

public class InvalidAvailabilityException extends  RuntimeException{
    public InvalidAvailabilityException(String message){
        super(message);
    }
}
