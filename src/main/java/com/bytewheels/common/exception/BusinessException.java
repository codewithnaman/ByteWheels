package com.bytewheels.common.exception;

public class BusinessException extends Exception {

    private String reasonCode;

    private String message;

    public BusinessException(String reasonCode, String message) {
        this.reasonCode = reasonCode;
        this.message = message;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
