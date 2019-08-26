package com.stock.app.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stock.app.dto.StocksRequestDTO;
import com.stock.app.dto.StocksResponseDTO;
import com.stock.app.entity.CMPMarket;
import com.stock.app.service.BuyStockService;
@RunWith(SpringJUnit4ClassRunner.class)
public class BuyStockControllerTest {
	
	@Mock
	BuyStockService buyStockService;
	
	
	@InjectMocks
	BuyStockController buyStockController;

	private MockMvc mockMvc;
	StocksRequestDTO stocksRequestDTO;
	
	
	@Before
	public void setUp() {
	
		
		mockMvc = MockMvcBuilders.standaloneSetup(buyStockController).build();
	}
	
	
	
	@Test
	public void testBuyStock() throws Exception {
		StocksRequestDTO stocksRequestDTO=new StocksRequestDTO();

		stocksRequestDTO.setPrice(100);
		stocksRequestDTO.setQuantity(2);
		stocksRequestDTO.setStockExchangeName("NSE");
		stocksRequestDTO.setStockId(1);
		
		CMPMarket cmpmarket= new  CMPMarket();
		cmpmarket.setMarketPrice(100);
		cmpmarket.setStockId(stocksRequestDTO.getStockId());
		
		
		StocksResponseDTO stocksResponseDTO = new StocksResponseDTO(); 
		stocksResponseDTO.setCurrentPrice(122);
		stocksResponseDTO.setPrice(100);
		stocksResponseDTO.setStockExchangeName("NSE");
		stocksResponseDTO.setTotalCurrentPrice(1000);
		
		
		Mockito.when(buyStockService.buyStock(Mockito.any())).thenReturn(stocksResponseDTO);
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/buyStock").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString("stocksRequestDTO"))).andReturn();

		ResponseEntity<StocksResponseDTO> actual=buyStockController.buyStock(stocksRequestDTO);
		assertEquals("NSE",actual.getBody().getStockExchangeName());
	}



	
public static String asJsonString(final Object obj) {
		
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}