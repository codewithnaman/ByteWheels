package com.bytewheels.customer.manager.impl;

import com.bytewheels.common.utility.DAOUtility;
import com.bytewheels.customer.constant.CustomerErrorCodes;
import com.bytewheels.customer.dao.Customer;
import com.bytewheels.customer.exception.CustomerServiceException;
import com.bytewheels.customer.manager.CustomerManager;
import com.bytewheels.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerManagerImpl implements CustomerManager{

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerByEmailId(String email) throws CustomerServiceException {
        Customer customer = customerRepository.findByEmail(email);
        if (customer == null) {
            throw new CustomerServiceException(
                    CustomerErrorCodes.CUSTOMER_NOT_FOUND.name(),
                    CustomerErrorCodes.CUSTOMER_NOT_FOUND.getMessage());
        }
        return customer;
    }

    @Override
    public Customer createCustomer(Customer customer) throws CustomerServiceException {
        customer.setId(DAOUtility.getUUID());
        customer.setModificationMetaData(DAOUtility.getCurrentModificationData());
        try {
            customer = customerRepository.save(customer);
        } catch (DataIntegrityViolationException exception) {
            throw new CustomerServiceException(CustomerErrorCodes.CUSTOMER_ALREADY_REGISTERED.name(),
                    CustomerErrorCodes.CUSTOMER_ALREADY_REGISTERED.getMessage());
        }
        return customer;
    }

    @Override
    public Customer getCustomerByCustomerId(String id) throws CustomerServiceException {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            throw new CustomerServiceException(
                    CustomerErrorCodes.CUSTOMER_NOT_FOUND.name(),
                    CustomerErrorCodes.CUSTOMER_NOT_FOUND.getMessage());
        }
        return customer.get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
