package com.hst.learninghub.user.service;

import com.hst.learninghub.user.entity.User;
import com.hst.learninghub.user.repository.UserRepository;
import com.hst.learninghub.user.ui.request.SignUpRequest;
import com.hst.learninghub.user.ui.response.SignUpResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public SignUpResponse signUp(SignUpRequest request) {
		User user = User.SignUpBuilder()
				.id(request.getId())
				.name(request.getName())
				.password(request.getPassword())
				.birthDate(request.getBirthDate())
				.roleType(request.getRoleType())
				.build();
		userRepository.save(user);
		return SignUpResponse.from(user);
	}

	@Override
	public UserDetails loadUserByUsername(String no) throws UsernameNotFoundException {
		return userRepository.findById(Long.valueOf(no))
				.orElseThrow(() -> new UsernameNotFoundException(String.format("Not found id %s", no)));
	}
}
