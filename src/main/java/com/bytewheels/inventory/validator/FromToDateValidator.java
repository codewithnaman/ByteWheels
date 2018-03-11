package com.bytewheels.inventory.validator;

import com.bytewheels.inventory.dto.InventorySearchRequestByDate;
import com.bytewheels.order.dto.OrderRequestDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component(value = "fromToDateValidator")
public class FromToDateValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return (InventorySearchRequestByDate.class.equals(clazz) || OrderRequestDetails.class.equals(clazz));
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            Date fromDate = null;
            Date toDate = null;
            if (target instanceof InventorySearchRequestByDate) {
                fromDate = ((InventorySearchRequestByDate) target).getFromDate();
                toDate = ((InventorySearchRequestByDate) target).getToDate();
            } else if (target instanceof OrderRequestDetails) {
                fromDate = ((OrderRequestDetails) target).getFromDate();
                toDate = ((OrderRequestDetails) target).getToDate();
            }
            if (fromDate.compareTo(toDate) > 0) {
                errors.rejectValue("toDate", null, "To Date is prior to From Date");
            }
        }
    }
}
