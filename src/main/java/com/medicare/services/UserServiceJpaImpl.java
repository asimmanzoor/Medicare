package com.medicare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.medicare.models.User;
import com.medicare.repositories.UserRepository;

import java.util.List;

@Service
@Primary
public class UserServiceJpaImpl implements UserService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> findAll() {
		return this.userRepo.findAll();
	}

	@Override
	public User findById(Long id) {
		return this.userRepo.findOne(id);
	}

	@Override
	public User create(User user) {
		return this.userRepo.save(user);
	}

	@Override
	public User edit(User user) {
		return this.userRepo.save(user);
	}

	@Override
	public void deleteById(Long id) {
		this.userRepo.delete(id);
	}

	@Override
	public boolean authenticate(String username, String password) {
		boolean isFound  = (userRepo.findAll()
				.stream()
				.filter(user -> user.getUsername().equals(username)
						&& user.getPasswordHash().equals(password))
				.count())  == 0 ?  false : true;
		return isFound;
		/*if (username.equals("admin")
				&& password.equals("admin")) {
			System.out.println("Authentication Done !");
		}
		return false;*/
	}
}
