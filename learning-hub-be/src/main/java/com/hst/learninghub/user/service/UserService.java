package com.hst.learninghub.user.service;

import com.hst.learninghub.user.entity.User;
import com.hst.learninghub.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}
}
