package com.stock.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.app.dto.ViewOrederResponseDto;

@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@RequestMapping("/api")
public class ViewOrderController {
	
	@GetMapping("/viewOrders/{userId}")
	public ResponseEntity<ViewOrederResponseDto> viewOrder(@PathVariable int userId )
	{
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
