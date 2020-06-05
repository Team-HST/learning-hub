package com.hst.learninghub.user.ui.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hst.learninghub.authentication.model.AuthenticationToken;
import com.hst.learninghub.user.entity.User;
import com.hst.learninghub.user.type.LoginStatus;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignInResponse {
    private String token;
    private UserResponse user;
    private LoginStatus status;

    /**
     * 로그인 성공 응답 정보
     * @param user
     * @param token
     * @return response
     */
    public static SignInResponse successLogin(User user, AuthenticationToken token) {
        SignInResponse response = new SignInResponse();
        response.token = token.getToken();
        response.user = UserResponse.from(user);
        response.status = LoginStatus.SUCCESS;
        return response;
    }

    /**
     * 로그인 실패 응답 정보
     * @param status
     * @return response
     */
    public static SignInResponse failedLogin(LoginStatus status) {
        SignInResponse response = new SignInResponse();
        response.status = status;
        return response;
    }
}
