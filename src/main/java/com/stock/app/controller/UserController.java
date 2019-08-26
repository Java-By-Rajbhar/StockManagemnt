package com.stock.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.app.dto.AccountResponseDto;
import com.stock.app.dto.UserRequestDto;
import com.stock.app.dto.UserResponseDto;
import com.stock.app.service.AccountService;
import com.stock.app.service.UserService;

/**
 * 
 * @author Sushil
 *
 */
@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/login")
	/**
	 * This service is use to user login  
	 * @param userRequestDto
	 * @return ResponseEntity<UserResponseDto>
	 */
	public ResponseEntity<UserResponseDto> userLogin(@RequestBody UserRequestDto userRequestDto)
	{
		logger.info("inside userLogin method of UserController class");
		UserResponseDto response =userService.userLogin(userRequestDto);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/accountById/{accountId}")
	/**
	 * This service is use to get account detail based on account id 
	 * @param accountId
	 * @return ResponseEntity<AccountResponseDto>
	 */
	public ResponseEntity<AccountResponseDto> getAccountById(@PathVariable int accountId)
	{
		logger.info("inside getAccountById method UserController class");
	    AccountResponseDto	response = accountService.getAccountByAccountId(accountId);
	    return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
