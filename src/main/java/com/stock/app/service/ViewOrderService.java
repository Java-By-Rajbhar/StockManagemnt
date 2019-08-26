package com.stock.app.service;

import java.util.List;

import com.stock.app.entity.MyStock;

public interface ViewOrderService {

	public List<MyStock> viewOrder(int id);
	
}
