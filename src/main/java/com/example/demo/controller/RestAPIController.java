package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.service.IUser;

@RestController
@RequestMapping("/account")
public class RestAPIController {

	@Autowired	
	@Qualifier("userImpl")
	IUser user;

	@PostMapping(path = "/sign-up")
	public ResponseEntity<ResponseDto> saveUser(@RequestBody RequestDto aRequest, HttpServletRequest request,
			HttpServletResponse response) {
		
		ResponseDto resp = user.saveUser(aRequest);

		return new ResponseEntity<ResponseDto>(resp, HttpStatus.OK);
	}
	
	@PostMapping(path = "/sign-in", consumes = { "application/json" })
	public ResponseEntity<ResponseDto> getUser(@RequestBody RequestDto aRequest, HttpServletRequest request,
			HttpServletResponse response) {
		
		ResponseDto resp = user.signInUser(aRequest);

		return new ResponseEntity<ResponseDto>(resp, HttpStatus.OK);
	}

}
