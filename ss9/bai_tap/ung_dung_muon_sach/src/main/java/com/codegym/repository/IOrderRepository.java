package com.codegym.repository;

import com.codegym.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOrderRepository extends JpaRepository<Orders, Integer> {

    @Query(value = "select * from orders where borrowc_code =:borrowcCode",nativeQuery = true)
    Orders getReturnsBook(@Param("borrowcCode") String borrowcCode);
}
