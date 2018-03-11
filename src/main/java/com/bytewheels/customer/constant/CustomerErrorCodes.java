package com.bytewheels.customer.constant;

public enum CustomerErrorCodes {
    CUSTOMER_NOT_FOUND("Customer not found "),
    CUSTOMER_ALREADY_REGISTERED("Customer already registered with given email");

    private String message;

    CustomerErrorCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
