package com.stock.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.app.dto.ViewOrederResponseDto;
import com.stock.app.entity.MyStock;
import com.stock.app.entity.Stock;
import com.stock.app.repository.MyStockRepository;
import com.stock.app.repository.StockRepository;


@Service
public class ViewOrderServiceImpl implements ViewOrderService {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ViewOrderServiceImpl.class);
	
	@Autowired
	private MyStockRepository myStockRepository;
	
	@Autowired
	private StockRepository stockRepository;

	@Override
	public List<ViewOrederResponseDto> viewOrder(int id) {

		
		LOGGER.info("ViewOrderServiceImpl viewOrder()");
		
		List<ViewOrederResponseDto> listOrederResponse=new ArrayList<>();
		
		
		 List<MyStock> listOrder=myStockRepository.findByUserId(id);
		 for (MyStock myStock : listOrder) {
			Stock stock= stockRepository.findByStockId(myStock.getStockId());
			ViewOrederResponseDto viewOrederResponseDto=new ViewOrederResponseDto();
			viewOrederResponseDto.setPrice(myStock.getPrice());
			viewOrederResponseDto.setQuantity(myStock.getQuantity());
			viewOrederResponseDto.setStatus(myStock.getStatus());
			viewOrederResponseDto.setStockname(stock.getStockName());
			viewOrederResponseDto.setTotalPrice(myStock.getTotalPrice());
			listOrederResponse.add(viewOrederResponseDto);
			 
		}
		 
		return listOrederResponse;
	}

}
