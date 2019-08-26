package com.stock.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.app.dto.UserRequestDto;

/**
 * 
 * @author Sushil
 *
 */
@RequestMapping("/api")
@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	public ResponseEntity<?> userLogin(@RequestBody UserRequestDto userRequestDto) {
		return null;
	}

}
