package com.bytewheels.common.exception;

import org.springframework.validation.FieldError;

import java.util.List;

public class InvalidFieldException extends Exception {

    List<FieldError> errors;

    public InvalidFieldException() {
    }

    public InvalidFieldException(List<FieldError> errors) {
        this.errors = errors;
    }

    public List<FieldError> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldError> errors) {
        this.errors = errors;
    }
}
