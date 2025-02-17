package com.techstack.orderservice.service;

import com.techstack.orderservice.factory.OrderStatusFactory;
import com.techstack.orderservice.model.Order;
import com.techstack.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Order createOrder() {
          Order order = new Order.OrderBuilder()
                  .withStatus("Created")
                  .build();
        return orderRepository.save(order);
    }

    @Transactional
    public Order updateOrderStatus(Long orderId, String newStatus) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Use Factory to update status
        OrderStatusFactory.updateOrderStatus(order, newStatus);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findOrdersByStatus(status);
    }
}