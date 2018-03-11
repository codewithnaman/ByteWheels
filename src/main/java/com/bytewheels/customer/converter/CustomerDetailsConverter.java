package com.bytewheels.customer.converter;

import com.bytewheels.customer.dao.Customer;
import com.bytewheels.customer.dto.CustomerDetails;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component(value = "customerDetailsConverter")
public class CustomerDetailsConverter implements Converter<Customer,CustomerDetails> {

    @Override
    public CustomerDetails convert(Customer customer) {
        CustomerDetails customerDetails = null;
        if(customer instanceof Customer ){
            customerDetails = new CustomerDetails();
            customerDetails.setEmail(customer.getEmail());
            customerDetails.setFirstName(customer.getFirstName());
            customerDetails.setId(customer.getId());
            customerDetails.setLastName(customer.getLastName());
            customerDetails.setMobileNumber(customer.getMobileNumber());
        }
        return customerDetails;
    }
}
