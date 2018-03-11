package com.bytewheels.customer.repository;

import com.bytewheels.customer.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findByEmail(String email);

}
