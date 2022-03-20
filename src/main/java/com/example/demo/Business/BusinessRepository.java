package com.example.demo.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long>{

    @Query(value = "SELECT * FROM business WHERE sid = :sidSearch", nativeQuery = true)
    List<Business> listBusinessbysid(@Param("sidSearch") Long sidSearch);
}
