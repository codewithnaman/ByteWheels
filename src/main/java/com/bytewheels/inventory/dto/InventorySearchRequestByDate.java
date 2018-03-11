package com.bytewheels.inventory.dto;

import com.bytewheels.common.utility.DateUtility;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InventorySearchRequestByDate {

    private static final String DATE_PATTERN =
            "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @NotEmpty
    @Pattern(regexp = DATE_PATTERN, message = "Invalid date provided")
    private String fromDate;

    @NotEmpty
    @Pattern(regexp = DATE_PATTERN, message = "Invalid date provided")
    private String toDate;

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
