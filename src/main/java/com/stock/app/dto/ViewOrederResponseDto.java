package com.stock.app.dto;



import com.stock.app.entity.MyStock;

import lombok.Data;

/**
 * 
 * @author Shashank
 *
 */
@Data
public class ViewOrederResponseDto {

	private String stockname;
	private int quantity;
	private double price;
	private String status;
	private double totalPrice;

}
