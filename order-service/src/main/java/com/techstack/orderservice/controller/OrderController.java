package com.techstack.orderservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.techstack.orderservice.service.OrderService;
import com.techstack.orderservice.model.Order;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder() {
        return orderService.createOrder();
    }

    @PutMapping("/{orderId}/status/{orderStatus}")
    public Order updateOrder(@PathVariable long orderId, @PathVariable String orderStatus) {
        return orderService.updateOrderStatus(orderId, orderStatus);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

}
