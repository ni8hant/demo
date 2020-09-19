package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.RewardEntry;

public interface IRewardService {

	List<RewardEntry> getRewardEntries(long id);

}
