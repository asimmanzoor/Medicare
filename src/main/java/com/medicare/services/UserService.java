package com.medicare.services;

import java.util.List;

import com.medicare.models.User;

public interface UserService {

	List<User> findAll();

	User findById(Long id);

	User create(User user);

	User edit(User user);

	void deleteById(Long id);

	boolean authenticate(String username, String password);

}