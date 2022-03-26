package com.example.demo.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{

    @Query(value = "SELECT * FROM food", nativeQuery = true)
    List<Food> listAllFood();

    @Query(value = "SELECT * FROM food WHERE bid = :bidSearch", nativeQuery = true)
    List<Food> listFoodByBid(@Param("bidSearch") Long bidSearch);

    @Query(value = "SELECT * FROM food WHERE fid = :fidSearch", nativeQuery = true)
    Food getFood(@Param("fidSearch") Long fidSearch);

}
