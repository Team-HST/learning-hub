package com.hst.learninghub.user.service;

import com.hst.learninghub.user.entity.User;
import com.hst.learninghub.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String no) throws UsernameNotFoundException {
		return userRepository.findById(Long.valueOf(no))
				.orElseThrow(() -> new UsernameNotFoundException(String.format("Not found id %s", no)));
	}
}
