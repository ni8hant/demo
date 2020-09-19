package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.dto.Customer;
import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.RewardEntry;
import com.example.demo.entity.UserDetails;
import com.example.demo.repository.RewardEntryRepo;
import com.example.demo.service.IUser;

@RestController
@RequestMapping("/account")
public class RestAPIController {

	@Autowired	
	@Qualifier("userImpl")
	IUser user;
	
	@Autowired	
	@Qualifier("rewardServiceRepo")
	RewardEntryRepo rewardEntryRepo;
	
	@Autowired	
	@Qualifier("userDetails")
	UserDetails userDetails;


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

	public int getTotalRewardsEarned(Customer customer) {
		
		List<RewardEntry> rewards = rewardEntryRepo.getRewardEntries(userDetails.getId());
		if(rewards==null) {
			return 0;
		}
		int totalPoint =0;
		for (int i = 0; i < rewards.size()-1; i++) {
			totalPoint+=rewards.get(i).getPoints();
		}
		return totalPoint;
		
	}
}
