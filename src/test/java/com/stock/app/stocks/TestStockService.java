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
		stock.setStockExchangeName("NES");
		stock.setStockId(101);
		stock.setStockName("Bharat Xchange");
		//stock.setTrending("2");
		stocks.add(stock);
		
	//	StockDto stockDto = new StockDto(101, "Bharat Xchange", 1220, 1, "2", "NES");
		//stockDtos.add(stockDto);
	}
	
	@Test
	public void testGetStocks() {
		Mockito.when(stockRepository.findAll()).thenReturn(stocks);
		List<StockDto> actualStockDtos = stockServiceImpl.getStocks();
		assertEquals(stocks.get(0).getStockExchangeName(), actualStockDtos.get(0).getStockExchangeName() );
	}
}
