package com.stock.app.dto;

import lombok.Data;

@Data
public class StocksRequestDTO {
	
	private int stockId;
	private String stockName;
	private double price;
	
	private int quantity;
	private int trending;
	private String stockExchangeName;
	private double userPrice;

}
