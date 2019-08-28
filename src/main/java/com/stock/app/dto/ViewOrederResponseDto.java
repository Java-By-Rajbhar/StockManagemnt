package com.stock.app.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Shashank
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewOrederResponseDto {

	private String stockname;
	private int quantity;
	private double price;
	private String status;
	private double totalPrice;

}
