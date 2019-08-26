package com.stock.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.app.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

	List<Stock> findFirst10ByOrderByTrendingDesc();

	List<Stock> findTop10ByOrderByTrendingDesc();

	public Stock findByStockId(int id);

}
