package com.stock.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StocksResponseDTO {
	
	private int statusCode;
	private int quantity;
	private double price;
	private double totalPrice;
	private double currentPrice;
	private double totalCurrentPrice;
	private int myStockId;
	private String stockExchangeName;
	private String stockName;

}
