package com.stock.app.stocks;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.stock.app.dto.StockDto;
import com.stock.app.entity.Stock;
import com.stock.app.repository.StockRepository;
import com.stock.app.service.StockServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestStockService {

	@Mock
	private StockRepository stockRepository;

	@InjectMocks
	private StockServiceImpl stockServiceImpl;

	List<Stock> stocks = new ArrayList<>();
	List<StockDto> stockDtos = new ArrayList<>();

	@Before
	public void setup() {
		Stock stock = new Stock();
		stock.setPrice(1220);
		stock.setQuantity(1);
		stock.setStockExchangeName("NSE");
		stock.setStockId(101);
		stock.setStockName("Bajaj Finance");
		stock.setTrending(2);
		stocks.add(stock);

		StockDto stockDto = new StockDto(101, "Bajaj Finance", 3345.0, 1, 1, "NSE", 2.45);
		stockDtos.add(stockDto);
	}

	@Test
	public void testGetStocks() {

		Mockito.when(stockRepository.findTop10ByOrderByTrendingDesc()).thenReturn(stocks);
		Mockito.when(stockRepository.findAll()).thenReturn(stocks);
		List<StockDto> actualStockDtos = stockServiceImpl.getStocks(false);
		assertEquals(stocks.get(0).getStockExchangeName(), actualStockDtos.get(0).getStockExchangeName());
	}
	
	@Test
	public void testGetTrendingStocks() {

		Mockito.when(stockRepository.findTop10ByOrderByTrendingDesc()).thenReturn(stocks);
		Mockito.when(stockRepository.findAll()).thenReturn(stocks);
		List<StockDto> actualStockDtos = stockServiceImpl.getStocks(true);
		assertEquals(stocks.get(0).getStockExchangeName(), actualStockDtos.get(0).getStockExchangeName());
	}
}
