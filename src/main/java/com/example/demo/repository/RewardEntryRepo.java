package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RewardEntry;

@Repository
public interface RewardEntryRepo {
	
	@Query("SELECT u FROM RewardEntry u where u.id=?1")
	List<RewardEntry> getRewardEntries(long id);

}
