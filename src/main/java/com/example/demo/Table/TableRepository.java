package com.example.demo.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TableRepository extends JpaRepository<Tables, Long>{
    List<Tables> findTablesByBid(Long bid);

    @Query(value = "SELECT * FROM shop_tables WHERE bid = :bidSearch and type = :typeSearch", nativeQuery = true)
    List<Tables> findTablesByBusinessIdAndType(@Param("bidSearch") Long bidSearch, @Param("typeSearch")  int typeSearch);
}
