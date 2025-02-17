package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.factory.OrderStatusFactory;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    //Inject OrderRepository Dependencies
    @Autowired
    private OrderRepository orderRepository;

    //Create Order using Builder
    @Transactional
    public Order createOrder() {
        Order order = new Order.OrderBuilder()
                .withStatus("Created")
                .build();
        return orderRepository.save(order);
    }

    //Update Order status
    @Transactional
    public Order updateOrderStatus(Long orderId, String newStatus) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        //Use Factory to update Order Status
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
