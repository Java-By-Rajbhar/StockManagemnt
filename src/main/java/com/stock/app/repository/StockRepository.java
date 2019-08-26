package com.stock.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.app.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

	public Stock findByStockId(int id);
}
