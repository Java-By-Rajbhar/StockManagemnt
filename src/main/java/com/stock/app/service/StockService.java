package com.stock.app.service;

import java.util.List;

import com.stock.app.dto.StockDto;

/**
 * @author Laxman
 *
 */
public interface StockService {

	List<StockDto> getStocks(Boolean tranding);

}
