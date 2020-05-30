package com.hst.learninghub.user.service;

import com.hst.learninghub.user.entity.User;
import com.hst.learninghub.user.repository.UserRepository;
import com.hst.learninghub.user.type.UserRole;
import com.hst.learninghub.user.ui.request.SignUpRequest;
import com.hst.learninghub.user.ui.request.UserResponse;
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

	/***
	 * 사용자 회원가입
	 * @param request 회원가입 요청
	 * @return 가입된 사용자 정보
	 */
	public UserResponse signUp(SignUpRequest request) {
		User user = User.builder()
				.id(request.getId())
				.name(request.getName())
				.password(request.getPassword())
				.birthDate(request.getBirthDate())
				.roleType(UserRole.get(request.getRoleType()))
				.build();
		user = userRepository.save(user);
		return UserResponse.from(user);
	}

	@Override
	public UserDetails loadUserByUsername(String no) throws UsernameNotFoundException {
		return userRepository.findById(Long.valueOf(no))
				.orElseThrow(() -> new UsernameNotFoundException(String.format("Not found id %s", no)));
	}
}
