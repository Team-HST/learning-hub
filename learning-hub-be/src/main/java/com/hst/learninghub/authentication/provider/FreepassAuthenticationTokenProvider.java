package com.hst.learninghub.authentication.provider;

import com.hst.learninghub.authentication.model.AuthenticationToken;
import com.hst.learninghub.configuration.properties.AppProperties;
import com.hst.learninghub.configuration.properties.AuthProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author hyungyu.lee@nhn.com
 */
@Component
@ConditionalOnProperty(prefix = "app", name = "auth.freepass.enable", havingValue = "true")
public class FreepassAuthenticationTokenProvider implements AuthenticationTokenProvider {

	private final AppProperties appProperties;

	public FreepassAuthenticationTokenProvider(AppProperties appProperties) {
		this.appProperties = appProperties;
	}

	@Override
	public AuthenticationToken issue(Long userNo) {
		return AuthenticationToken.builder()
				.token(String.format("%s_%d", getFreePassProps().getMasterToken(), userNo))
				.userNo(userNo)
				.build();
	}

	@Override
	public Long getTokenOwnerNo(String token) {
		String[] items = token.split("_");
		return Long.valueOf(items[1]);
	}

	@Override
	public boolean validateToken(String token) {
		return true;
	}

	private AuthProperties.FreepassProperties getFreePassProps() {
		return appProperties.getAuth().getFreepass();
	}

}
