package com.techstack.orderservice.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //Constructor to enforce Object creation through Builder
    private Order(OrderBuilder builder) {
        this.status = builder.status;
        this.createdAt = builder.createdAt;
        this.updatedAt = LocalDateTime.now();
    }

    protected Order() {

    }

    //Nested static Builder class
    public static class OrderBuilder {
        private String status;
        private final LocalDateTime createdAt = LocalDateTime.now();
        private LocalDateTime updatedAt = LocalDateTime.now();


        //Chaining method
        public OrderBuilder withStatus(String status) {
            this.status = status;
            return this;
        }

        //Building Order Entity
        public Order build() {
            return new Order(this);
        }
    }

    //Method to update Order status (Used by Factory)
    public void updateStatus(String newStatus) {
        this.status = newStatus;
        this.updatedAt = LocalDateTime.now();
    }
}
