package com.example.orderservice.factory;

import com.example.orderservice.model.Order;

//Factory to update order status
public class OrderStatusFactory {
    public static void updateOrderStatus(Order order, String newStatus) {
        order.updateStatus(newStatus); //using encapsulated order method
    }
}
