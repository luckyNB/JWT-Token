package com.cultivationsession.service;

import org.springframework.stereotype.Service;

import com.cultivationsession.dto.LoginDTO;
import com.cultivationsession.dto.UserDTO;
import com.cultivationsession.util.Response;
@Service
public interface IUserService {
	/**
	 * @param userDto
	 * @return
	 * @throws UserException
	 * @throws UnsupportedEncodingException
	 */
	Response onRegister(UserDTO userDto) ;

	/**
	 * @param loginDto
	 * @return
	 * @throws UserException
	 * @throws UnsupportedEncodingException
	 */
	Response onLogin(LoginDTO loginDto) ;

	Long getUserID(String token);

}
