package com.stock.app.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stock.app.dto.UserRequestDto;
import com.stock.app.dto.UserResponseDto;
import com.stock.app.entity.User;
import com.stock.app.repository.UserRepository;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Test
	public void testUserLogin() {
		
		User user=new User();
		user.setAccountId(1234);
		user.setLoginName("shashank");
		user.setPassword("ok");
		user.setUserId(1);
		UserRequestDto userRequestDto=new UserRequestDto();
		userRequestDto.setLoginName("shashank");
		userRequestDto.setPassword("ok");
		
		when(userRepository.findByLoginName(Mockito.anyString())).thenReturn(user);
		UserResponseDto actual=userServiceImpl.userLogin(userRequestDto);
		assertEquals(1234, actual.getAccountId());
	}

}
