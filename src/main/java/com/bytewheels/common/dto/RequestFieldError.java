package com.bytewheels.common.dto;

public class RequestFieldError {

    private String fieldName;

    private String message;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        RequestFieldError that = (RequestFieldError) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(fieldName, that.fieldName)
                .append(message, that.message)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(fieldName)
                .append(message)
                .toHashCode();
    }
}
