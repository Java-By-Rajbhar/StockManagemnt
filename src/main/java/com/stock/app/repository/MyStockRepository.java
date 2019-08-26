package com.stock.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.app.entity.MyStock;


@Repository
public interface MyStockRepository extends JpaRepository<MyStock, Integer> {

	public List<MyStock> findByUserId(int id);
	
	public MyStock findById(int myStockId);
	
}
