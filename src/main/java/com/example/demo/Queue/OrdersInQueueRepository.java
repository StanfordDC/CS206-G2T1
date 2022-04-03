package com.example.demo.Queue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrdersInQueueRepository extends JpaRepository<OrdersInQueue, Long>{

    @Query(value = "SELECT * FROM orders_in_queue WHERE bid = :bidSearch", nativeQuery = true)
    List<OrdersInQueue> findOrdersInQueueByBid(@Param("bidSearch") Long bidSearch);

    @Query(value = "SELECT * FROM orders_in_queue WHERE bid = :bidSearch and oid = :oidSearch", nativeQuery = true)
    OrdersInQueue findOrderByBidAndOid(@Param("bidSearch") Long bidSearch, @Param("oidSearch") Long oidSearch);

    @Query(value = "SELECT * FROM orders_in_queue WHERE bid = :bidSearch and status = :statusSearch", nativeQuery = true)
    List<OrdersInQueue> findAllOrdersInQueueByBidAndStatus(@Param("bidSearch") Long bidSearch, @Param("statusSearch") int statusSearch);

    // @Query(value = "SELECT * FROM shop_tables WHERE bid = :bidSearch and type = :typeSearch", nativeQuery = true)
    // List<OrdersInQueue> findTablesByBusinessIdAndType(@Param("bidSearch") Long bidSearch, @Param("typeSearch")  int typeSearch);
}
