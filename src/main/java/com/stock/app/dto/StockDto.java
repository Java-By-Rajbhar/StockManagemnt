package com.stock.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Laxman
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {
	
	private int stockId;
	
	private String stockName;
	private double price;
	private int quantity;
	private int trending;
	private String stockExchangeName;
	private double stockPercentage;

}
