package com.stock.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.app.dto.StockDto;
import com.stock.app.service.StockService;

/**
 * @author Laxman
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class StockController {

	/**
	 * slf4j Logger
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(StockController.class);
	
	@Autowired
	private StockService stockService;
	
	/**
	 * @return ResponseEntity ListOfStock
	 */
	@GetMapping("/stocks")
	public ResponseEntity<List<StockDto>> getStockes(){
		
		LOGGER.info("StockController :: getStockes() ");
		
		return new ResponseEntity<>(stockService.getStocks(), HttpStatus.OK);
	}
}
