package com.stock.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stock.app.entity.MyStock;
import com.stock.app.repository.MyStockRepository;

public class ViewOrderServiceImpl implements ViewOrderService {
	
	
	@Autowired
	private MyStockRepository myStockRepository;

	@Override
	public List<MyStock> viewOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
