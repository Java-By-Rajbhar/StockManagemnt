package com.stock.app.service;

import com.stock.app.dto.UserRequestDto;
import com.stock.app.dto.UserResponseDto;

/**
 * 
 * @author Sushil
 *
 */
public interface UserService {
	
	public UserResponseDto userLogin(UserRequestDto userRequestDto);

}
