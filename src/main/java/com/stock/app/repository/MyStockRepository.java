package com.stock.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.app.entity.MyStock;

public interface MyStockRepository extends JpaRepository<MyStock, Integer> {

}
