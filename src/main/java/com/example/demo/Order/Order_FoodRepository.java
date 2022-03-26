package com.example.demo.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Order_FoodRepository extends JpaRepository<Order_Food, Long> {
    @Query(value = "SELECT * FROM order_food WHERE oid = :oidSearch", nativeQuery = true)
    List<Order_Food> listOrderByOid(@Param("oidSearch") Long oidSearch);

    @Query(value = "SELECT * FROM order_food WHERE ofid = :ofidSearch", nativeQuery = true)
    Order_Food getOrder_Food(@Param("ofidSearch") Long ofidSearch);
}
