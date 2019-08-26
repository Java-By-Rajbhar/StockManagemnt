package com.stock.app.dto;

import lombok.Data;

/**
 * 
 * @author Sushil
 *
 */
@Data
public class UserResponseDto {
	
	private int statusCode;
	private String message;
	private int accountId;

}
