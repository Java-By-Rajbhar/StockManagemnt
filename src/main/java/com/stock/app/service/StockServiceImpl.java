package com.stock.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.app.dto.StockDto;
import com.stock.app.entity.Stock;
import com.stock.app.repository.StockRepository;

/**
 * @author Laxman
 *
 */
@Service
public class StockServiceImpl implements StockService {

	/**
	 * slf4j Logger
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(StockServiceImpl.class);
	
	@Autowired
	private StockRepository stockRepository;
	
	/**
	 * return
	 */
	@Override
	public List<StockDto> getStocks() {
		
		LOGGER.info("StockServiceImpl :: getStocks ");
		
		List<Stock> stocks = stockRepository.findAll();
		List<StockDto> stocksDto = new ArrayList<>();
		if(!stocks.isEmpty()) {
			for(Stock stock : stocks) {
				StockDto stockDto = new StockDto();
				LOGGER.info("StockServiceImpl :: getStocks -- Copying stock -> stockDto ");
				BeanUtils.copyProperties(stock, stockDto);
				stocksDto.add(stockDto);
			}
		}
		LOGGER.info("StockServiceImpl :: getStocks -- end");
		return stocksDto;
	}
}
