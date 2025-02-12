package com.logonedigital.pi_mentorat_virtuel.exception;

public class ResourceExistException extends RuntimeException{
    public ResourceExistException(String message) {
        super(message);
    }
}