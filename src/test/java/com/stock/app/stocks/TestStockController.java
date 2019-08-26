package com.stock.app.stocks;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.print.attribute.standard.MediaSize.ISO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stock.app.controller.StockController;
import com.stock.app.service.StockServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestStockController {

	private MockMvc mockMvc;
	
	@Mock
	private StockController stockController;
	
	@InjectMocks
	private StockServiceImpl stockServiceImpl;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(stockController).build();
	}
	
	@Test
	public void testGetStocks() throws Exception {
		mockMvc.perform(get("/api/stocks").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
