package com.bytewheels.order.converter;

import com.bytewheels.order.dao.Order;
import com.bytewheels.order.dto.OrderResponseDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component("allOrdersDetailsConverter")
public class AllOrdersDetailsConverter implements Converter<List<Order>, List<OrderResponseDetails>> {

    @Autowired
    @Qualifier(value = "orderDetailsConverter")
    private Converter orderDetailsConverter;

    @Override
    public List<OrderResponseDetails> convert(List<Order> source) {
        List<OrderResponseDetails> orderResponseDetailsList = new ArrayList<>();
        for(Order order : source){
            OrderResponseDetails orderResponseDetails = (OrderResponseDetails) orderDetailsConverter.convert(order);
            orderResponseDetailsList.add(orderResponseDetails);
        }
        return orderResponseDetailsList;
    }
}
