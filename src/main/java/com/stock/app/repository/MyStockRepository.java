package com.stock.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.app.entity.MyStock;


@Repository
public interface MyStockRepository extends JpaRepository<MyStock, Integer> {

}
