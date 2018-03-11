package com.bytewheels.order.repository;

import com.bytewheels.order.dao.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
