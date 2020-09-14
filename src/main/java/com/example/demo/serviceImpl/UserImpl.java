package com.example.demo.serviceImpl;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.responsestatus.ResponseStatus;
import com.example.demo.service.IUser;

@Service("userImpl")
public class UserImpl implements IUser {

	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseDto saveUser(RequestDto aRequest) {
		User user = userRepository.findByUserName(aRequest.getUsername());
		ResponseDto response = new ResponseDto();
		if (user == null) {
			response.setStatus(ResponseStatus.ERROR.getKey());
			response.setCode(ResponseStatus.ERROR.getValue());
			response.setMessage("Account Already Exist ");
			return response;
		}

		User u = new User();
		u.setUsername(aRequest.getUsername());
		u.setPassword(aRequest.getPassword());
		u.setToken(generateRandomPassword(10));
		userRepository.save(u);
		response.setStatus(ResponseStatus.OK.getKey());
		response.setCode(ResponseStatus.OK.getValue());
		response.setMessage("Account Create");
		return response;
	}

	@Override
	public ResponseDto signInUser(RequestDto aRequest) {
		ResponseDto response = new ResponseDto();
		User user = userRepository.findByUserName(aRequest.getUsername());
		if (user == null) {
			response.setStatus(ResponseStatus.ERROR.getKey());
			response.setCode(ResponseStatus.ERROR.getValue());
			response.setMessage("Account Doesn't exist");
			return response;
		}
		if (user.getPassword().equals(aRequest.getPassword())) {
			user.setToken(generateRandomPassword(10));
			userRepository.save(user);
			response.setStatus(ResponseStatus.OK.getKey());
			response.setCode(ResponseStatus.OK.getValue());
			response.setMessage("Sign In Successful");
			return response;
		}
		response.setStatus(ResponseStatus.ERROR.getKey());
		response.setCode(ResponseStatus.ERROR.getValue());
		response.setMessage("Username Pawwsord Mismatch");
		return response;

	}

	public String generateRandomPassword(int len) {
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			int randomIndex = random.nextInt(chars.length());
			sb.append(chars.charAt(randomIndex));
		}

		return sb.toString();
	}

}
