package com.bytewheels.customer.converter;

import com.bytewheels.customer.dao.Customer;
import com.bytewheels.customer.dto.RegisterCustomerRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component(value = "customerRequestConverter")
public class CustomerRegistrationRequestConverter implements Converter<RegisterCustomerRequest, Customer> {

    @Override
    public Customer convert(RegisterCustomerRequest request) {
        Customer customer = null;
        if (request instanceof RegisterCustomerRequest) {
            customer = new Customer();
            customer.setEmail(request.getEmail());
            customer.setFirstName(request.getFirstName());
            customer.setLastName(request.getLastName());
            customer.setMobileNumber(request.getMobileNumber());
        }
        return customer;
    }
}
