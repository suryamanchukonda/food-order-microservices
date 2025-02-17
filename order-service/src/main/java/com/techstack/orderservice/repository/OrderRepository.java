package com.techstack.orderservice.repository;

import com.techstack.orderservice.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, CustomOrderRepository {

}
