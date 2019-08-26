package com.stock.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.app.entity.Stock;

public interface StocksRepository extends JpaRepository<Stock, Integer>{
	Stock findByStockId(int stockId);


}
