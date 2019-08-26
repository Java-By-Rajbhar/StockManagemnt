package com.stock.app.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stock.app.dto.ViewOrederResponseDto;
import com.stock.app.entity.MyStock;
import com.stock.app.entity.Stock;
import com.stock.app.repository.MyStockRepository;
import com.stock.app.repository.StockRepository;
@RunWith(SpringJUnit4ClassRunner.class)
public class ViewOrderServiceImplTest {

	@Mock
	MyStockRepository myStockRepository;
	
	@Mock
	StockRepository stockRepository;
	
	@InjectMocks
	ViewOrderServiceImpl viewOrderServiceImpl;
	
	
	@Test
	public void testViewOrder() {
		
		MyStock mystock = new MyStock();
		mystock.setId(1);
		mystock.setPrice(100);
		mystock.setQuantity(3);
		mystock.setStatus("CANCEL");
		mystock.setStockId(1);
		mystock.setTotalPrice(1000.0);
		mystock.setUserId(1);
		
		List<MyStock> myStockList=new ArrayList<>();
		myStockList.add(mystock);
		ViewOrederResponseDto viewOrederResponseDto=new ViewOrederResponseDto();
		
		viewOrederResponseDto.setPrice(100);
		viewOrederResponseDto.setQuantity(3);
		viewOrederResponseDto.setStatus("BUY");
		viewOrederResponseDto.setStockname("ING VISYA");
		viewOrederResponseDto.setTotalPrice(1000);
		
		Stock stock=new Stock();
		stock.setPrice(100);;
		stock.setQuantity(1);
		stock.setStockExchangeName("ING VISYA");
		stock.setStockId(1);
		stock.setStockName("NSE");
		stock.setTrending(1);
		
		List<ViewOrederResponseDto> myOrder =new ArrayList<>();
		myOrder.add(viewOrederResponseDto);

		when(myStockRepository.findByUserId(Mockito.anyInt())).thenReturn(myStockList);
		when(stockRepository.findByStockId(Mockito.anyInt())).thenReturn(stock);
		
		List<ViewOrederResponseDto> actual=viewOrderServiceImpl.viewOrder(1);
		
		assertEquals(1, actual.size());
	}

}
