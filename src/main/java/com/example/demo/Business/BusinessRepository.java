package com.example.demo.Business;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long>{
    Optional<Business> findByUEN(String UEN);

    Boolean existsByUEN(String UEN);

    List<Business> findByMid(Long mid);
}
