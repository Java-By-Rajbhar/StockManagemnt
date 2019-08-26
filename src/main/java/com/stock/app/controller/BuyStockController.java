package com.stock.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.app.dto.MyStockRequestDto;
import com.stock.app.dto.MyStockStatusResponse;
import com.stock.app.dto.StocksRequestDTO;
import com.stock.app.dto.StocksResponseDTO;
import com.stock.app.service.BuyStockService;
import com.stock.app.service.MyStockService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@RequestMapping("/api")
public class BuyStockController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BuyStockController.class);

	@Autowired
	BuyStockService buyStockService;
	@Autowired
	MyStockService myStockService;

	@PostMapping("/buyStock")
	public ResponseEntity<StocksResponseDTO> buyStock(@RequestBody StocksRequestDTO stocksRequestDTO) {
		LOGGER.info("inside INGStockX");
		StocksResponseDTO stocksResponseDTO = buyStockService.buyStock(stocksRequestDTO);
		return new ResponseEntity<>(stocksResponseDTO, HttpStatus.OK);
	}

	@PostMapping("/confirm")
	public ResponseEntity<MyStockStatusResponse> confirmBuyStock(@RequestBody MyStockRequestDto myStockRequestDto) {
		LOGGER.info("inside confirmBuyStock");
		MyStockStatusResponse response = myStockService.confirmMyStock(myStockRequestDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
