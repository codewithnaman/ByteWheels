package com.bytewheels.order.service.impl;

import com.bytewheels.common.service.impl.OrderEmailService;
import com.bytewheels.customer.dao.Customer;
import com.bytewheels.customer.exception.CustomerServiceException;
import com.bytewheels.customer.manager.CustomerManager;
import com.bytewheels.inventory.dao.ItemCategory;
import com.bytewheels.inventory.dao.ItemInventory;
import com.bytewheels.inventory.dto.ItemCategoryResponse;
import com.bytewheels.inventory.exceptions.InventoryServiceException;
import com.bytewheels.inventory.manager.ItemInventoryManager;
import com.bytewheels.inventory.manager.ItemManager;
import com.bytewheels.order.constant.OrderErrorCodes;
import com.bytewheels.order.dao.Order;
import com.bytewheels.order.dto.OrderRequestDetails;
import com.bytewheels.order.dto.OrderResponseDetails;
import com.bytewheels.order.exception.OrderServiceException;
import com.bytewheels.order.manager.OrderManager;
import com.bytewheels.order.service.OrderService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private CustomerManager customerManager;

    @Autowired
    private ItemInventoryManager itemInventoryManager;

    @Autowired
    private ItemManager itemManager;

    @Autowired
    private OrderManager orderManager;

    @Autowired
    @Qualifier("orderMailService")
    private OrderEmailService orderEmailService;

    @Autowired
    @Qualifier(value = "orderDetailsConverter")
    private Converter orderDetailsConverter;

    @Autowired
    @Qualifier(value = "allOrdersDetailsConverter")
    private Converter<List<Order>, List<OrderResponseDetails>> allOrdersDetailsConverter;
    public OrderResponseDetails createOrder(OrderRequestDetails requestDetails) throws OrderServiceException {
        OrderResponseDetails orderResponseDetails = null;
        Customer customer = null;
        List<ItemInventory> availableItemInventory = null;
        try {
            customer = customerManager.getCustomerByCustomerId(requestDetails.getCustomerId());
        } catch (CustomerServiceException exception) {
            throw new OrderServiceException(OrderErrorCodes.CUSTOMER_NOT_FOUND.name(),
                    OrderErrorCodes.CUSTOMER_NOT_FOUND.getMessage());
        }
        try {
            itemManager.getItemById(requestDetails.getItemId());
        } catch (InventoryServiceException e) {
            throw new OrderServiceException(OrderErrorCodes.ITEM_NOT_FOUND.name(),
                    OrderErrorCodes.ITEM_NOT_FOUND.getMessage());
        }
        availableItemInventory = itemInventoryManager.
                getAvailableInventoryItemsByDateAndItemId(requestDetails.getFromDate(), requestDetails.getToDate(), requestDetails.getItemId());
        if (availableItemInventory == null || availableItemInventory.size() <= 0) {
            throw new OrderServiceException(OrderErrorCodes.INVENTORY_NOT_AVAILABLE.name(),
                    OrderErrorCodes.INVENTORY_NOT_AVAILABLE.getMessage());
        }
        ItemInventory inventoryToAssign = availableItemInventory.get(0);

        long diff = DateUtils.addDays(requestDetails.getToDate(), 1).getTime() - requestDetails.getFromDate().getTime();
        long numberOfDaysToHire = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        float priceForItem = (inventoryToAssign.getItem().getPrice() != null &&
                inventoryToAssign.getItem().getPrice() != 0) ? inventoryToAssign.getItem().getPrice()
                : inventoryToAssign.getItem().getItemCategory().getPrice();
        float totalAmount = numberOfDaysToHire * priceForItem;
        Order order = new Order();
        order.setCustomer(customer);
        order.setItemInventory(inventoryToAssign);
        order.setTotalAmount(totalAmount);
        order.setFromDate(requestDetails.getFromDate());
        order.setToDate(requestDetails.getToDate());
        order = orderManager.createOrder(order);
        orderResponseDetails = (OrderResponseDetails) orderDetailsConverter.convert(order);
        orderEmailService.sendMail(orderResponseDetails.getCustomerEmail(), orderResponseDetails);
        return orderResponseDetails;
    }

    @Override
    public OrderResponseDetails getOrder(String orderId) throws OrderServiceException{
        Order order = orderManager.getOrder(orderId);
        OrderResponseDetails orderResponseDetails= (OrderResponseDetails)orderDetailsConverter.convert(order);
        return orderResponseDetails;
    }

    @Override
    public List<OrderResponseDetails> getOrders() {
        List<Order> orders = orderManager.getOrders();
        List<OrderResponseDetails> orderResponseDetails = allOrdersDetailsConverter.convert(orders);
        return orderResponseDetails;
    }

    @Override
    public void removeOrderById(String orderId) {
        orderManager.removeOrderById(orderId);
    }

}
