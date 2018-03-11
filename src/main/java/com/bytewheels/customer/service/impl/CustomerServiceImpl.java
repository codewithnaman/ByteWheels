package com.bytewheels.customer.service.impl;

import com.bytewheels.customer.dao.Customer;
import com.bytewheels.customer.dto.CustomerDetails;
import com.bytewheels.customer.dto.RegisterCustomerRequest;
import com.bytewheels.customer.exception.CustomerServiceException;
import com.bytewheels.customer.manager.CustomerManager;
import com.bytewheels.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerManager customerManager;

    @Autowired
    @Qualifier(value = "customerDetailsConverter")
    private Converter customerDetailsConverter;

    @Autowired
    @Qualifier(value = "customerRequestConverter")
    private Converter customerRequestConverter;


    public CustomerDetails getCustomerByEmail(String email) throws CustomerServiceException {
        Customer customer = customerManager.getCustomerByEmailId(email);
        CustomerDetails customerDetails = (CustomerDetails) customerDetailsConverter.convert(customer);
        return customerDetails;
    }

    @Override
    public CustomerDetails registerCustomer(RegisterCustomerRequest registerCustomerRequest) throws CustomerServiceException {
        Customer customer = (Customer) customerRequestConverter.convert(registerCustomerRequest);
        customer = customerManager.createCustomer(customer);
        CustomerDetails customerDetails = (CustomerDetails) customerDetailsConverter.convert(customer);
        return customerDetails;
    }

    @Override
    public List<CustomerDetails> getAllCustomers() {
        List<Customer> customers = customerManager.getAllCustomers();
        List<CustomerDetails> customerDetails = new ArrayList<>();
        for (Customer customer : customers) {
            customerDetails.add((CustomerDetails) customerDetailsConverter.convert(customer));
        }
        return customerDetails;
    }
}
