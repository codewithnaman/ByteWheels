package com.bytewheels.order.controller;

import com.bytewheels.common.controller.BaseController;
import com.bytewheels.common.exception.InvalidFieldException;
import com.bytewheels.common.utility.WebServiceEndPoints;
import com.bytewheels.order.dto.OrderRequestDetails;
import com.bytewheels.order.dto.OrderResponseDetails;
import com.bytewheels.order.exception.OrderServiceException;
import com.bytewheels.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController extends BaseController {

    @Autowired
    @Qualifier("fromToDateValidator")
    private Validator fromToDateValidator;

    @Autowired
    private OrderService orderService;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(fromToDateValidator);
    }

    @RequestMapping(value = WebServiceEndPoints.ORDER, method = RequestMethod.POST)
    public OrderResponseDetails createOrder(@RequestBody
                                            @Validated OrderRequestDetails orderRequestDetails,
                                            BindingResult bindingResult) throws InvalidFieldException, OrderServiceException {
        validRequest(bindingResult);
        OrderResponseDetails orderResponseDetails = orderService.createOrder(orderRequestDetails);
        return orderResponseDetails;
    }

    @RequestMapping(value = WebServiceEndPoints.ORDER+"/{orderId}", method = RequestMethod.GET)
    public  OrderResponseDetails getOrder(@PathVariable("orderId") String orderId) throws OrderServiceException{
        return orderService.getOrder(orderId);
    }

    @RequestMapping(value = WebServiceEndPoints.ORDER, method = RequestMethod.GET)
    public List<OrderResponseDetails> getOrders(){
        return orderService.getOrders();
    }

    @RequestMapping(value = WebServiceEndPoints.ORDER+"/{orderId}", method = RequestMethod.DELETE)
    public void removeOrderById(@PathVariable("orderId") String orderId){
        orderService.removeOrderById(orderId);
    }
}
