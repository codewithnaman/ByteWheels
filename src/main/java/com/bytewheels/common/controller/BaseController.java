package com.bytewheels.common.controller;

import com.bytewheels.common.exception.InvalidFieldException;
import org.springframework.validation.BindingResult;

public abstract class BaseController {
    public void validRequest(BindingResult bindingResult) throws InvalidFieldException {
        if (bindingResult.hasErrors()) {
            throw new InvalidFieldException(bindingResult.getFieldErrors());
        }
    }
}
