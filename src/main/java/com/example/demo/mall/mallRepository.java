package com.example.demo.mall;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MallRepository extends JpaRepository<Mall, Long>{
    
}
