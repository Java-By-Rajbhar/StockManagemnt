package com.stock.app.service;

import java.util.List;

import com.stock.app.dto.ViewOrederResponseDto;

public interface ViewOrderService {

	public List<ViewOrederResponseDto> viewOrder(int id);
	
}
