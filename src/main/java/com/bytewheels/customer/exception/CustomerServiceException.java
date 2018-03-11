package com.bytewheels.customer.exception;

import com.bytewheels.common.exception.BusinessException;

public class CustomerServiceException extends BusinessException {

    public CustomerServiceException(String reasonCode, String message) {
        super(reasonCode, message);
    }


}
