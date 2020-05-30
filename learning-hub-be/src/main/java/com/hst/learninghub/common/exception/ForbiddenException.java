package com.hst.learninghub.common.exception;

import org.springframework.http.HttpStatus;

/**
 * @author dlgusrb0808@gmail.com
 */
public class ForbiddenException extends ReportableException {
	private static final long serialVersionUID = 1L;

	public ForbiddenException(String message, Object... args) {
		super(message, args);
	}

	@Override
	public ErrorDescription toErrorDescription() {
		return ErrorDescription.create(HttpStatus.FORBIDDEN, this);
	}
}
