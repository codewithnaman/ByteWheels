package com.bytewheels.order.converter;

import com.bytewheels.common.utility.DateUtility;
import com.bytewheels.order.dao.Order;
import com.bytewheels.order.dto.OrderResponseDetails;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component(value = "orderDetailsConverter")
public class OrderDetailsConverter implements Converter<Order, OrderResponseDetails> {

    @Override
    public OrderResponseDetails convert(Order order) {
        OrderResponseDetails orderResponseDetails = new OrderResponseDetails();
        orderResponseDetails.setOrderId(order.getId());
        orderResponseDetails.setCarCategory(order.getItemInventory().getItem().getItemCategory().getName());
        orderResponseDetails.setCarDescription(order.getItemInventory().getItem().getDescription());
        orderResponseDetails.setCarName(order.getItemInventory().getItem().getName());
        orderResponseDetails.setCustomerEmail(order.getCustomer().getEmail());
        orderResponseDetails.setCustomerFirstName(order.getCustomer().getFirstName());
        orderResponseDetails.setCustomerLastName(order.getCustomer().getLastName());
        orderResponseDetails.setCustomerMobileNumber(order.getCustomer().getMobileNumber());
        orderResponseDetails.setTotalAmount(order.getTotalAmount());
        orderResponseDetails.setAllocatedCarRegistrationNumber(order.getItemInventory().getRegistrationNumber());
        orderResponseDetails.setFromDate(DateUtility.getDateAsString(order.getFromDate()));
        orderResponseDetails.setToDate(DateUtility.getDateAsString(order.getToDate()));
        return orderResponseDetails;
    }
}
