package com.example.demo.Business;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long>{
    Optional<Business> findByUEN(String UEN);

    Boolean existsByUEN(String UEN);

    List<Business> findByMid(Long mid);

    @Query(value = "SELECT * FROM orders_in_queue WHERE bid = :bidSearch", nativeQuery = true)
    Business getBusinessById(@Param("bidSearch") Long bidSearch);
}
