package com.logonedigital.pi_mentorat_virtuel.Exception;

public class ResourceExistException extends RuntimeException{
    public ResourceExistException(String message) {
        super(message);
    }
}