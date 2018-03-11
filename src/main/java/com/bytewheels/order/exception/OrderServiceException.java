package com.bytewheels.order.exception;

import com.bytewheels.common.exception.BusinessException;

public class OrderServiceException extends BusinessException {

    public OrderServiceException(String reasonCode, String message) {
        super(reasonCode, message);
    }

}
