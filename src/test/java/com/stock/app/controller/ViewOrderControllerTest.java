package com.stock.app.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
import com.stock.app.dto.ViewOrederResponseDto;
import com.stock.app.entity.MyStock;
import com.stock.app.service.ViewOrderService;


@RunWith(SpringJUnit4ClassRunner.class)
public class ViewOrderControllerTest {

	@Mock
	ViewOrderService viewOrderService;
	
	@InjectMocks
	ViewOrderController viewOrderController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
	
		
		mockMvc = MockMvcBuilders.standaloneSetup(viewOrderController).build();
	}
	
	@Test
	public void test() throws Exception {
		
		MyStock mystock = new MyStock();
		mystock.setId(1);
		mystock.setPrice(100);
		mystock.setQuantity(3);
		mystock.setStatus("CANCEL");
		mystock.setStockId(1);
		mystock.setTotalPrice(1000.0);
		mystock.setUserId(1);
		ViewOrederResponseDto viewOrederResponseDto=new ViewOrederResponseDto();
		
		viewOrederResponseDto.setPrice(100);
		viewOrederResponseDto.setQuantity(3);
		viewOrederResponseDto.setStatus("BUY");
		viewOrederResponseDto.setStockname("ING VISYA");
		viewOrederResponseDto.setTotalPrice(1000);
		
		
		
		List<ViewOrederResponseDto> myOrder =new ArrayList<>();
		myOrder.add(viewOrederResponseDto);

		Mockito.when(viewOrderService.viewOrder(Mockito.anyInt())).thenReturn(myOrder);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/viewOrders/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(""))).andReturn();
		 ResponseEntity<List<ViewOrederResponseDto>>  actual=viewOrderController.viewOrder(1);
		 assertEquals(1, actual.getBody().size());
	}

	
	public static String asJsonString(final Object obj) {
		
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
