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
public class MyStockStatusResponse {

	private int statusCode;
	private String message;
}
