package com.hst.learninghub.configuration;

import com.hst.learninghub.configuration.entrypoint.RestAuthenticationEntryPoint;
import com.hst.learninghub.configuration.filter.ExceptionHandlingFilter;
import com.hst.learninghub.configuration.filter.TokenAuthenticationFilter;
import com.hst.learninghub.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String[] PUBLIC_URI = {
			"/",
			"/favicon.ico",
			"/error",
			"/user/sign-in",
			"/user/sign-up",
//			"/**"
	};

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/v2/api-docs", "/swagger-resources/**",
				"/swagger-ui.html", "/webjars/**", "/swagger/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()
				.and()
			.httpBasic()
				.disable()
			.csrf()
				.disable()
			.formLogin()
				.disable()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
			.authorizeRequests()
				.antMatchers(PUBLIC_URI)
					.permitAll()
				.anyRequest()
					.authenticated()
				.and()
			.exceptionHandling()
				.authenticationEntryPoint(new RestAuthenticationEntryPoint())
		;

		http.addFilterBefore(exceptionHandlingFilter(), CorsFilter.class);
		http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public TokenAuthenticationFilter tokenAuthenticationFilter() {
		return new TokenAuthenticationFilter();
	}


	@Bean
	public ExceptionHandlingFilter exceptionHandlingFilter() {
		return new ExceptionHandlingFilter();
	}
}
