package com.stock.app.dto;

import lombok.Data;

@Data
public class StocksResponseDTO {
	
	private int statusCode;
	private int quantity;
	private double price;
	private double totalPrice;
	private double currentPrice;
	private double totalCurrentPrice;
	private int myStockId;

}
