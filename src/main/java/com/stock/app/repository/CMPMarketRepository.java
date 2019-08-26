package com.stock.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.app.entity.CMPMarket;

public interface CMPMarketRepository extends JpaRepository<CMPMarket, Integer> {

	Optional<CMPMarket> findByStockId(int stockId);

}
