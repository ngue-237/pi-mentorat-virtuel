package com.logonedigital.pi_mentorat_virtuel.exception;


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}