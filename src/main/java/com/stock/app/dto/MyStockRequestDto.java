package com.stock.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Sushil
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyStockRequestDto {

	private int id;
	private String status;
	private int quantity;
	private double price;
	private double currentPrice;
	private double totalCurrentPrice;
}
