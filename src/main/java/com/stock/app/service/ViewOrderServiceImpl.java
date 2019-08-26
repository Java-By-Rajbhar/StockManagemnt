package com.stock.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.app.dto.ViewOrederResponseDto;
import com.stock.app.entity.MyStock;
import com.stock.app.repository.MyStockRepository;


@Service
public class ViewOrderServiceImpl implements ViewOrderService {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ViewOrderServiceImpl.class);
	
	@Autowired
	private MyStockRepository myStockRepository;

	@Override
	public ViewOrederResponseDto viewOrder(int id) {

		
		LOGGER.info("ViewOrderServiceImpl viewOrder()");
		ViewOrederResponseDto viewOrederResponseDto=new ViewOrederResponseDto();
		
		
		 List<MyStock> listOrder=myStockRepository.findByUserId(id);
		 viewOrederResponseDto.setOderList(listOrder);
		return viewOrederResponseDto;
	}

}
