package com.bytewheels.customer.manager;

import com.bytewheels.customer.dao.Customer;
import com.bytewheels.customer.exception.CustomerServiceException;

import java.util.List;

public interface CustomerManager {

    Customer getCustomerByEmailId(String emailId) throws CustomerServiceException;

    Customer createCustomer(Customer customer) throws CustomerServiceException;

    Customer getCustomerByCustomerId(String id) throws CustomerServiceException;

    List<Customer> getAllCustomers();
}
