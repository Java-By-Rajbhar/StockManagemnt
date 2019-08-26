package com.stock.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.stock.app.dto.UserRequestDto;
import com.stock.app.dto.UserResponseDto;
import com.stock.app.entity.User;
import com.stock.app.exception.InvalidCredentialsException;
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
		// get user object based on login name
		User user = userRepository.findByLoginName(userRequestDto.getLoginName());
		logger.info("user data={}",user.getPassword());
		if (user.getLoginName().equals(userRequestDto.getLoginName())
				&& user.getPassword().equals(userRequestDto.getPassword())) {
			UserResponseDto responseDto = new UserResponseDto();
			responseDto.setStatusCode(HttpStatus.OK.value());
			responseDto.setMessage(user.getLoginName() + " has logged in successfully");
			responseDto.setAccountId(user.getAccountId());
			return responseDto;
		} else {
			logger.error("username or password wrong ={}",userRequestDto.getPassword());
			throw new InvalidCredentialsException("Username/Password is wrong !!!!");
		}
	}

}
