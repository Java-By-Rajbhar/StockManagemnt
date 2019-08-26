package com.stock.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.app.dto.UserRequestDto;
import com.stock.app.dto.UserResponseDto;
import com.stock.app.repository.UserRepository;
/**
 * 
 * @author Sushil
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserResponseDto userLogin(UserRequestDto userRequestDto) {
		logger.info("inside userLogin method of UserServiceImpl class");
		
		return null;
	}

}
