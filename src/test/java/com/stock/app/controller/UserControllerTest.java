package com.stock.app.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stock.app.dto.AccountResponseDto;
import com.stock.app.dto.UserRequestDto;
import com.stock.app.dto.UserResponseDto;
import com.stock.app.entity.User;
import com.stock.app.service.AccountService;
import com.stock.app.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {
	
	@Mock
	UserService userService;
	
	@Mock
	AccountService accountService;
	
	@InjectMocks
	UserController userController;

	private MockMvc mockMvc;
	UserRequestDto userRequestDto;
	
	@Before
	public void setUp() {
	
		
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	
	
	@Test
	public void testUserLogin() throws Exception {

		User user=new User();
		user.setAccountId(1234);
		user.setLoginName("shashank");
		user.setPassword("ok");
		user.setUserId(1);
		UserRequestDto userRequestDto=new UserRequestDto();
		userRequestDto.setLoginName("shashank");
		userRequestDto.setPassword("ok");
		UserResponseDto userResponseDto=new UserResponseDto();
		userResponseDto.setAccountId(1234);
		userResponseDto.setMessage("ok");
		userResponseDto.setStatusCode(200);
		
		Mockito.when(userService.userLogin(Mockito.any())).thenReturn(userResponseDto);
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString("userRequestDto"))).andReturn();

		ResponseEntity<UserResponseDto> actual=userController.userLogin(userRequestDto);
		assertEquals(1234, actual.getBody().getAccountId());
	}

	@Test
	public void testGetAccountById() throws Exception {
		
		AccountResponseDto accountResponseDto=new AccountResponseDto();
		accountResponseDto.setAccountHolderName("xyz");
		accountResponseDto.setAccountNumber(1234);
		accountResponseDto.setBalance(1000);
		
		Mockito.when(accountService.getAccountByAccountId(Mockito.anyInt())).thenReturn(accountResponseDto);

		mockMvc.perform(MockMvcRequestBuilders.post("/accountById/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(""))).andReturn();
		ResponseEntity<AccountResponseDto> actual=userController.getAccountById(1);
		assertEquals("xyz", actual.getBody().getAccountHolderName());
		
	
	}

	
public static String asJsonString(final Object obj) {
		
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
