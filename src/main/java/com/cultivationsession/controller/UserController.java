package com.cultivationsession.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cultivationsession.dto.LoginDTO;
import com.cultivationsession.dto.UserDTO;
import com.cultivationsession.service.IUserService;
import com.cultivationsession.util.Response;

@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	IUserService userService;

	
	@PostMapping("/register")
	public ResponseEntity<Response> register( @RequestBody UserDTO userDto)
			   {
		Response response = userService.onRegister(userDto);
		System.out.println(response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}


	@PostMapping("/login")
	public ResponseEntity<Response> onLogin( @RequestBody LoginDTO loginDTO)
		{
		Response response = userService.onLogin(loginDTO);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/decode")
	public Long onDecodingToken(@RequestHeader String token){
		Long userId=userService.getUserID(token);
		System.out.println("UserID=================>"+userId);
		return userId;
	}
	
}
