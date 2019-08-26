package com.stock.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.app.dto.ViewOrederResponseDto;
import com.stock.app.service.ViewOrderService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@RequestMapping("/api")
public class ViewOrderController {
	
	@Autowired
	private ViewOrderService viewOrderService;
	
	@GetMapping("/viewOrders/{userId}")
	public ResponseEntity<List<ViewOrederResponseDto>> viewOrder(@PathVariable int userId )
	{
		
		
		
		return new ResponseEntity<>(viewOrderService.viewOrder(userId),HttpStatus.OK);
	}

}
