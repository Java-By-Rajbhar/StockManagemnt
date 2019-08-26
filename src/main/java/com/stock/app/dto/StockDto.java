package com.stock.app.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Laxman
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int stockId;
	
	private String stockName;
	private double price;
	private int quantity;
	private String trending;
	private String stockExchangeName;
	private double stockPercentage;

}
