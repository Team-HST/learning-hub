package com.hst.learninghub.configuration;

import com.hst.learninghub.configuration.filter.ExceptionHandlingFilter;
import com.hst.learninghub.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.filter.CorsFilter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String[] PUBLIC_URI = {
			"/**",
//			"/favicon.ico",
//			"/error",
	};

	private final UserService userService;

	@Override
	public void configure(WebSecurity web) {
		web
			.ignoring()
			.antMatchers(
		"/v2/api-docs",
					"/configuration/**",
					"/swagger-resources/**",
					"/swagger-ui.html",
					"/webjars/**", "/swagger/**"
			);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()
				.and()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
			.csrf()
				.disable()
			.formLogin()
				.disable()
			.httpBasic()
				.disable()
			.authorizeRequests()
				.antMatchers(PUBLIC_URI)
					.permitAll()
				.anyRequest()
					.authenticated()
				.and()
		;

		http.addFilterBefore(exceptionHandlingFilter(), CorsFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}



	@Bean
	public ExceptionHandlingFilter exceptionHandlingFilter() {
		return new ExceptionHandlingFilter();
	}
}
