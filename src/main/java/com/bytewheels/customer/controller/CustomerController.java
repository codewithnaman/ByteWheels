package com.bytewheels.customer.controller;

import com.bytewheels.common.controller.BaseController;
import com.bytewheels.common.exception.BusinessException;
import com.bytewheels.common.exception.InvalidFieldException;
import com.bytewheels.common.utility.WebServiceEndPoints;
import com.bytewheels.customer.dto.CustomerDetails;
import com.bytewheels.customer.dto.RegisterCustomerRequest;
import com.bytewheels.customer.exception.CustomerServiceException;
import com.bytewheels.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Validated
@RestController
public class CustomerController extends BaseController{

    @Autowired
    private CustomerService customerService;

    public static final String EMAIL_VERIFICATION = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";


    @RequestMapping(value = WebServiceEndPoints.CUSTOMER_EMAIL_SEARCH + "/{email}", method = RequestMethod.GET)
    public CustomerDetails getCustomerByEmail(@NotEmpty @Pattern(regexp = EMAIL_VERIFICATION, message = "Invalid E-mail Provided") @PathVariable("email") String emailId) throws BusinessException {
        return customerService.getCustomerByEmail(emailId);
    }

    @RequestMapping(value = WebServiceEndPoints.CUSTOMER, method = RequestMethod.POST)
    public ResponseEntity<CustomerDetails> registerCustomer(@RequestBody @Validated RegisterCustomerRequest registerCustomerRequest,
                                                            BindingResult result) throws InvalidFieldException, CustomerServiceException {
        validRequest(result);
        CustomerDetails customerDetails = customerService.registerCustomer(registerCustomerRequest);
        return new ResponseEntity<CustomerDetails>(customerDetails, HttpStatus.CREATED);
    }

    @RequestMapping(value = WebServiceEndPoints.CUSTOMER, method = RequestMethod.GET)
    public List<CustomerDetails> getAllCustomers() {
        List<CustomerDetails> customerDetailsList = customerService.getAllCustomers();
        return customerDetailsList;
    }

}
