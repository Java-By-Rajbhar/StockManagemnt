package com.stock.app.service;

import com.stock.app.dto.MyStockRequestDto;
import com.stock.app.dto.MyStockStatusResponse;
/**
 * 
 * @author Sushil
 *
 */
public interface MyStockService {
	
	public MyStockStatusResponse confirmMyStock(MyStockRequestDto myStockRequestDto);

}
