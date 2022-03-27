package com.example.demo.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT * FROM orders", nativeQuery = true)
    List<Order> listAllOrder();

    @Query(value = "SELECT * FROM orders WHERE cid = :cidSearch", nativeQuery = true)
    List<Order> listOrderbycid(@Param("cidSearch") Long cidSearch);
}
