package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u FROM User u where u.username=?1")
	User findByUserName(String username);

	/*
	 * @Query("SELECT u FROM User u where u.username=?1 and u.password =?2") User
	 * findByUserNameAndPassword(String username, String password);
	 */

}
