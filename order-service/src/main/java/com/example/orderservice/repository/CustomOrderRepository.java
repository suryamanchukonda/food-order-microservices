package com.example.orderservice.repository;

import com.example.orderservice.model.Order;
import java.util.List;

public interface CustomOrderRepository {
    List<Order> findOrdersByStatus(String status);
}
