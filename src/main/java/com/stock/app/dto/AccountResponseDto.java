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
public class AccountResponseDto {

	private int accountNumber;
	private double balance;
	private String accountHolderName;
}
