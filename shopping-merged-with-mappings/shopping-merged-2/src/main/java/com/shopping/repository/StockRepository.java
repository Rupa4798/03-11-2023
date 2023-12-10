package com.shopping.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}