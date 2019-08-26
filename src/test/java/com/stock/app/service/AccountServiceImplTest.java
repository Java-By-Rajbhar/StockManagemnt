package com.stock.app.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stock.app.dto.AccountResponseDto;
import com.stock.app.entity.Account;
import com.stock.app.repository.AccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceImplTest {

	@Mock
	AccountRepository accountRepository;
	
	
	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	
	@Test
	public void testGetAccountByAccountId() {

		Account account =new Account();
		account.setAccountHoldername("shashank");
		account.setAccountId(1);
		account.setAccountNumber(1234);
		account.setBalance(10000);
		
		when(accountRepository.findByAccountId(Mockito.anyInt())).thenReturn(account);
		
		AccountResponseDto accountResponseDtoActual=	accountServiceImpl.getAccountByAccountId(1);
		assertEquals("shashank", accountResponseDtoActual.getAccountHolderName());
	
	}

}
