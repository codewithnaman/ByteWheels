package com.bytewheels.order.constant;

public enum OrderErrorCodes {
    CUSTOMER_NOT_FOUND("Customer not found for the given customer id"),
    ITEM_NOT_FOUND("Item not found for the given item id"),
    INVENTORY_NOT_AVAILABLE("Request Item is not available"),
    ORDER_UNAVAILABLE("Unable to find order with given order id");

    private String message;

    OrderErrorCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
