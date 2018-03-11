package com.bytewheels.order.dto;

import com.bytewheels.common.utility.DateUtility;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

public class OrderRequestDetails implements Serializable {

    private static final long serialVersionUID = -7108386853266134725L;

    private static final String DATE_PATTERN =
            "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";


    @NotEmpty
    private String customerId;

    @NotEmpty
    private String itemId;

    @NotEmpty
    @Pattern(regexp = DATE_PATTERN, message = "Invalid date provided")
    private String fromDate;

    @NotEmpty
    @Pattern(regexp = DATE_PATTERN, message = "Invalid date provided")
    private String toDate;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @FutureOrPresent
    public Date getFromDate() {
        return DateUtility.getDateFromString(fromDate);
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    @FutureOrPresent
    public Date getToDate() {
        return DateUtility.getDateFromString(toDate);
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }


}
