package com.stock.app.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stock.app.dto.StocksRequestDTO;
import com.stock.app.dto.StocksResponseDTO;
import com.stock.app.dto.UserRequestDto;
import com.stock.app.entity.CMPMarket;
import com.stock.app.entity.Stock;
import com.stock.app.repository.CMPMarketRepository;
import com.stock.app.repository.MyStockRepository;
import com.stock.app.repository.StocksRepository;


@RunWith(SpringJUnit4ClassRunner.class)
public class BuyStockServiceImplTest {

	@Mock
	CMPMarketRepository cPMarketRepository;

	@Mock
	StocksRepository stocksRepository;

	@Mock
	MyStockRepository myStockRepository;

	
	@InjectMocks
	BuyStockServiceImpl buyStockServiceImpl;
	
	@Test
	public void buyStockTest() {
		
		
		  StocksRequestDTO stocksRequestDTO=new StocksRequestDTO();
		  
		  stocksRequestDTO.setPrice(100);
		  stocksRequestDTO.setQuantity(2);
		  stocksRequestDTO.setStockExchangeName("NSE");
		  stocksRequestDTO.setStockId(1);
		  
		  CMPMarket cmpmarket= new CMPMarket(); cmpmarket.setMarketPrice(100);
		  cmpmarket.setStockId(stocksRequestDTO.getStockId());
		  
		  
		  StocksResponseDTO stocksResponseDTO = new StocksResponseDTO();
		  stocksResponseDTO.setCurrentPrice(122); stocksResponseDTO.setPrice(100);
		  stocksResponseDTO.setStockExchangeName("NSE");
		  stocksResponseDTO.setTotalCurrentPrice(1000);
		  
		  Stock stock =new Stock();
		  stock.setPrice(100);
		  stock.setQuantity(1);
		  stock.setStockExchangeName("ING VAIYSA");
		  stock.setStockId(1);
		  stock.setStockName("NSE");
		  stock.setStockPercentage(0.10);
		  stock.setTrending(1);
		  
		  
		  CMPMarket cMPMarket =new CMPMarket();
		  cMPMarket.setCmpId(1);
		  cMPMarket.setDateTime(new Date());
		  cMPMarket.setMarketPrice(100.0);
		  cMPMarket.setStockId(1);
		  
		  Optional<CMPMarket> optional=Optional.of(cMPMarket);
		  
		  
		  
		  UserRequestDto userRequestDto=new UserRequestDto();
		  userRequestDto.setLoginName("rachana");
		  userRequestDto.setPassword("ok");
		  
		  when(stocksRepository.findByStockId(Mockito.anyInt())).thenReturn(stock);
		  when(cPMarketRepository.findByStockId(Mockito.anyInt())).thenReturn(optional);
		  
		  
		  
		  StocksResponseDTO actual=buyStockServiceImpl.buyStock(stocksRequestDTO);
		 assertEquals("NSE", actual.getStockExchangeName());
	}

}
