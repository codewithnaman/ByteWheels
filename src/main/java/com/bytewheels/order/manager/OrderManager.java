package com.bytewheels.order.manager;

import com.bytewheels.order.dao.Order;
import com.bytewheels.order.exception.OrderServiceException;

import java.util.List;

public interface OrderManager {

    Order createOrder(Order order);

    Order getOrder(String orderId) throws OrderServiceException;

    List<Order> getOrders();

    void removeOrderById(String orderId);
}
