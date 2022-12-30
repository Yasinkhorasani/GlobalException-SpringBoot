package com.controllerAdvice.Annotation.exception;

public class ResourceNotFoundException extends RuntimeException{
  public ResourceNotFoundException(String message){
      super(message);
  }
}
