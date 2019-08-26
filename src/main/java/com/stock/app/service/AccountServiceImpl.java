package com.stock.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.app.dto.AccountResponseDto;
import com.stock.app.entity.Account;
import com.stock.app.repository.AccountRepository;

/**
 * 
 * @author Sushil
 *
 */
@Service
public class AccountServiceImpl implements AccountService {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public AccountResponseDto getAccountByAccountId(int accountId) {
		logger.info("inside getAccountByAccountId method of AccountServiceImpl class");
		Account account = accountRepository.findByAccountId(accountId);
		AccountResponseDto responseDto = new AccountResponseDto();
		responseDto.setAccountNumber(account.getAccountNumber());
		responseDto.setBalance(account.getBalance());
		responseDto.setAccountHolderName(account.getAccountHoldername());
		
		return responseDto;
	}

}
