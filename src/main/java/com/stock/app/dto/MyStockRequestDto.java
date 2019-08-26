package com.stock.app.dto;

import lombok.Data;

/**
 * 
 * @author Sushil
 *
 */
@Data
public class MyStockRequestDto {

	private int id;
	private String status;
	private int quantity;
	private double price;
	private double currentPrice;
	private double totalCurrentPrice;
}
