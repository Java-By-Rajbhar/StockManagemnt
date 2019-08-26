package com.stock.app.service;

import com.stock.app.dto.AccountResponseDto;

/**
 * 
 * @author Sushil
 *
 */
public interface AccountService {
	
	public AccountResponseDto getAccountByAccountId(int accountId);

}
