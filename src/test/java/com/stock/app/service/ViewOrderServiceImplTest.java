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
import com.stock.app.repository.MyStockRepository;
@RunWith(SpringJUnit4ClassRunner.class)
public class ViewOrderServiceImplTest {

	@Mock
	MyStockRepository myStockRepository;
	
	@InjectMocks
	ViewOrderServiceImpl viewOrderServiceImpl;
	
	
	@Test
	public void testViewOrder() {
		
		MyStock mystock = new MyStock();
		mystock.setId(1);
		mystock.setPrice(100);
		mystock.setQuantity(3);
		mystock.setStatus("CANCEL");
		mystock.setStockExchangeName("ING VAYSYA");
		mystock.setStockId(1);
		mystock.setTotalPrice(1000.0);
		mystock.setUserId(1);
		List<MyStock> myOrder =new ArrayList<>();
		myOrder.add(mystock);

		when(myStockRepository.findByUserId(Mockito.anyInt())).thenReturn(myOrder);
		ViewOrederResponseDto viewOrederResponseDtoActual=	viewOrderServiceImpl.viewOrder(1);
		assertEquals(1, viewOrederResponseDtoActual.getOderList().size());
	}

}
