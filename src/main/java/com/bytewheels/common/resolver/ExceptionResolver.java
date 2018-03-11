package com.bytewheels.common.resolver;

import com.bytewheels.common.dto.ErrorResponse;
import com.bytewheels.common.dto.RequestFieldError;
import com.bytewheels.common.exception.BusinessException;
import com.bytewheels.common.exception.InvalidFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(InvalidFieldException.class)
    public ResponseEntity<List<RequestFieldError>> resolveFieldErrors(InvalidFieldException exception) {
        Map<String, RequestFieldError> errors = new HashMap<>();
        for (FieldError fieldError : exception.getErrors()) {
            if (errors.get(fieldError.getField()) == null) {
                RequestFieldError requestFieldError = new RequestFieldError();
                requestFieldError.setFieldName(fieldError.getField());
                requestFieldError.setMessage(fieldError.getDefaultMessage());
                errors.put(fieldError.getField(), requestFieldError);
            }
        }
        return new ResponseEntity<List<RequestFieldError>>(new ArrayList<RequestFieldError>(errors.values()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> resolveBusinessException(BusinessException businessException) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMesssage(businessException.getMessage());
        errorResponse.setReasonCode(businessException.getReasonCode());
        return new ResponseEntity<ErrorResponse>(
                errorResponse, HttpStatus.BAD_REQUEST
        );

    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<List<RequestFieldError>> resolveInputParameterErrors(ConstraintViolationException exception) {
        List<RequestFieldError> errors = new ArrayList<>();
        for (ConstraintViolation violation : exception.getConstraintViolations()) {
            RequestFieldError error = new RequestFieldError();
            error.setMessage(violation.getMessage());
            error.setFieldName("INVALID_RESOURCE_ID");
            errors.add(error);
        }
        return new ResponseEntity<List<RequestFieldError>>(errors,
                HttpStatus.BAD_REQUEST);
    }
}
