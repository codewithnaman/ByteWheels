package com.bytewheels.inventory.exceptions;

import com.bytewheels.common.exception.BusinessException;


public class ItemCategoryNotFoundException extends BusinessException {
    public ItemCategoryNotFoundException(String reasonCode, String message) {
        super(reasonCode, message);
    }
}
