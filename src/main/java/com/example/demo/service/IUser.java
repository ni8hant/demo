package com.example.demo.service;

import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;

public interface IUser {

	ResponseDto saveUser(RequestDto aRequest);

	ResponseDto signInUser(RequestDto aRequest);

}
