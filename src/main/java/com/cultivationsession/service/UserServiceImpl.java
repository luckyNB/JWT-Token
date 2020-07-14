package com.cultivationsession.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cultivationsession.dto.LoginDTO;
import com.cultivationsession.dto.UserDTO;
import com.cultivationsession.model.User;
import com.cultivationsession.repository.UserRepository;
import com.cultivationsession.util.Response;
import com.cultivationsession.util.TokenUtil;
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	UserRepository userRepo;

	@Autowired
	private TokenUtil tokenUtil;

	@Override
	public Response onRegister(UserDTO userDto) {

		User user = modelMapper.map(userDto, User.class);
		userRepo.save(user);
		Response statusResponse = new Response(200, "register successfully", "");
		return statusResponse;
	}

	public Response onLogin(LoginDTO loginDto) {
		// extract user details by using emailid
		Optional<User> user = userRepo.findByEmailId(loginDto.getEmail());
		System.out.println(user);
		if (user.isPresent()) {

			String token = tokenUtil.createToken(user.get().getUserId());

			Response response = new Response(200, "Login Successfully", token);
			return response;

		}
		return null;

	}

	@Override
	public Long getUserID(String token) {
		Long userID= tokenUtil.decodeToken(token);
		System.out.println("UserID"+userID);
		// TODO Auto-generated method stub
		return userID;
	}

}
