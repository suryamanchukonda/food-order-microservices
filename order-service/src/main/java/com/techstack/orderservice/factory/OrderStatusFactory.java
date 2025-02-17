package com.techstack.orderservice.factory;

import com.techstack.orderservice.model.Order;

//Factory to update order status
public class OrderStatusFactory {
    public static void updateOrderStatus(Order order, String newStatus) {
        order.updateStatus(newStatus); //using encapsulated order method
    }
}
