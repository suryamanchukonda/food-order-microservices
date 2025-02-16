package com.example.orderservice.repository;

import com.example.orderservice.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.EntityManager;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
