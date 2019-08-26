package com.stock.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.stock.app.dto.MyStockRequestDto;
import com.stock.app.dto.MyStockStatusResponse;
import com.stock.app.entity.MyStock;
import com.stock.app.repository.MyStockRepository;

/**
 * 
 * @author Sushil
 *
 */
@Service
public class MyStockServiceImpl implements MyStockService {
	private static final Logger logger = LoggerFactory.getLogger(MyStockServiceImpl.class);
	@Autowired
	MyStockRepository myStockRepository;

	@Override
	public MyStockStatusResponse confirmMyStock(MyStockRequestDto myStockRequestDto) {
		logger.info("inside getMyStock method of MyStockServiceImpl class");
		MyStock mystock = myStockRepository.findById(myStockRequestDto.getId());
		MyStockStatusResponse response=null;
		if(mystock!=null)
		{
			mystock.setStatus(myStockRequestDto.getStatus());
			myStockRepository.save(mystock);
			 response  = new MyStockStatusResponse();
			response.setMessage("Stock with id "+mystock.getStockId()+" has been purchased successfully");
			response.setStatusCode(HttpStatus.OK.value());
		}
		else
		{
			return null;
		}
		return response;
		
	}

}
