package com.bytewheels.order.manager.impl;

import com.bytewheels.common.utility.DAOUtility;
import com.bytewheels.order.constant.OrderErrorCodes;
import com.bytewheels.order.dao.Order;
import com.bytewheels.order.exception.OrderServiceException;
import com.bytewheels.order.manager.OrderManager;
import com.bytewheels.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderManagerImpl implements OrderManager {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        order.setId(DAOUtility.getUUID());
        order.setModificationMetaData(DAOUtility.getCurrentModificationData());
        order = orderRepository.save(order);
        return order;
    }

    @Override
    public Order getOrder(String orderId) throws OrderServiceException {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(!optionalOrder.isPresent()){
            throw new OrderServiceException(OrderErrorCodes.ORDER_UNAVAILABLE.name(),
                    OrderErrorCodes.ORDER_UNAVAILABLE.getMessage());
        }
        return optionalOrder.get();
    }

    @Override
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    @Override
    public void removeOrderById(String orderId) {
        orderRepository.deleteById(orderId);
    }
}
