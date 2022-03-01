package com.example.demo.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BusinessRepository extends JpaRepository<Business, Long>{
    List<Business> findByBusinessID(Long Id);
}
