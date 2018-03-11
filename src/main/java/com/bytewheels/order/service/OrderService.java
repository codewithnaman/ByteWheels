package com.bytewheels.order.service;

import com.bytewheels.order.dao.Order;
import com.bytewheels.order.dto.OrderRequestDetails;
import com.bytewheels.order.dto.OrderResponseDetails;
import com.bytewheels.order.exception.OrderServiceException;

import java.util.List;

public interface OrderService {

    OrderResponseDetails createOrder(OrderRequestDetails requestDetails) throws OrderServiceException;

    OrderResponseDetails getOrder(String orderId) throws OrderServiceException;

    List<OrderResponseDetails> getOrders();

    void removeOrderById(String orderId);
}
