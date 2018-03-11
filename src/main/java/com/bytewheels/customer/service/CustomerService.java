package com.bytewheels.customer.service;

import com.bytewheels.customer.dto.CustomerDetails;
import com.bytewheels.customer.dto.RegisterCustomerRequest;
import com.bytewheels.customer.exception.CustomerServiceException;

import java.util.List;

public interface CustomerService {

    CustomerDetails getCustomerByEmail(String email) throws CustomerServiceException;

    CustomerDetails registerCustomer(RegisterCustomerRequest registerCustomerRequest) throws CustomerServiceException;

    List<CustomerDetails> getAllCustomers();

}
