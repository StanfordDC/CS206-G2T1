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

    @Query(value = "SELECT * FROM orders WHERE cid = :cidSearch && order_status != 0", nativeQuery = true)
    List<Order> listOrderByCid(@Param("cidSearch") Long cidSearch);

    @Query(value = "SELECT * FROM orders WHERE bid = :bidSearch && order_status != 0", nativeQuery = true)
    List<Order> listOrderByBid(@Param("bidSearch") Long bidSearch);

    @Query(value = "SELECT * FROM orders WHERE oid = :oidSearch && order_status != 0", nativeQuery = true)
    Order getOrder(@Param("oidSearch") Long oidSearch);

}
