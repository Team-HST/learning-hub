package com.hst.learninghub.configuration.filter;

import com.hst.learninghub.common.exception.ErrorDescription;
import com.hst.learninghub.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author dlgusrb0808@gmail.com
 */
public class ExceptionHandlingFilter extends OncePerRequestFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlingFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
		try {
			filterChain.doFilter(request, response);
		} catch (Exception e) {
			String msg = String.format("Exception occur on filter on %s", request.getRequestURI());
			LOGGER.error(msg, e);
			sendErrorResponse(e, response);
		}
	}

	private void sendErrorResponse(Exception e, HttpServletResponse response) throws IOException {
		if (e instanceof ResponseStatusException) {
			response.setStatus(((ResponseStatusException) e).getStatus().value());
		} else {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.getWriter().write(JsonUtils.serialize(ErrorDescription.create(HttpStatus.UNAUTHORIZED, e)));
	}

}
