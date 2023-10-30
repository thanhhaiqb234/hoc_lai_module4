package com.codegym.repository;

import com.codegym.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Orders, Integer> {
}
