package com.techstack.orderservice.repository;

import com.techstack.orderservice.model.Order;
import java.util.List;

public interface CustomOrderRepository {
    List<Order> findOrdersByStatus(String status);
}
