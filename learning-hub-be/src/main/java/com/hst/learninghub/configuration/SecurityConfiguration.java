package com.hst.learninghub.configuration;

import com.hst.learninghub.configuration.filter.ExceptionHandlingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.filter.CorsFilter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String[] PUBLIC_URI = {
			"/**",
//			"/favicon.ico",
//			"/error",
	};

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

	@Bean
	public ExceptionHandlingFilter exceptionHandlingFilter() {
		return new ExceptionHandlingFilter();
	}


}
