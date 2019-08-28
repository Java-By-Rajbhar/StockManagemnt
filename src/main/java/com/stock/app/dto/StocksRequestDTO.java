package com.stock.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StocksRequestDTO {
	
	private int stockId;
	private String stockName;
	private double price;
	
	private int quantity;
	private int trending;
	private String stockExchangeName;
	private double userPrice;
	private int userId;

}
