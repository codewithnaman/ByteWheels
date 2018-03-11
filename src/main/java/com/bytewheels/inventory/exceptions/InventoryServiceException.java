package com.bytewheels.inventory.exceptions;

import com.bytewheels.common.exception.BusinessException;

public class InventoryServiceException extends BusinessException {
    public InventoryServiceException(String reasonCode, String message) {
        super(reasonCode, message);
    }
}
