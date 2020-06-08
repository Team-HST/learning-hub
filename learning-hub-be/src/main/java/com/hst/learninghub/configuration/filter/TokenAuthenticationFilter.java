package com.hst.learninghub.configuration.filter;

import com.hst.learninghub.authentication.provider.AuthenticationTokenProvider;
import com.hst.learninghub.common.exception.ForbiddenException;
import com.hst.learninghub.user.entity.User;
import com.hst.learninghub.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dlgusrb0808@gmail.com
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(TokenAuthenticationFilter.class);

	@Autowired
	private AuthenticationTokenProvider authenticationTokenProvider;

	@Autowired
	private UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = authenticationTokenProvider.parseTokenString(request);
		if (authenticationTokenProvider.validateToken(token)) {
			Long userNo = authenticationTokenProvider.getTokenOwnerNo(token);
			try {
				User member = (User) userService.loadUserByUsername(userNo.toString());
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(member,
						member.getPassword(), member.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			} catch (UsernameNotFoundException e) {
				throw new ForbiddenException("유효하지않은 인증토큰 입니다. 인증토큰 회원 정보 오류");
			}
		}
		filterChain.doFilter(request, response);
	}
}
