package com.hst.learninghub.user.ui.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class SignInRequest {
    @ApiModelProperty(name = "로그인 ID", example = "aaaa")
    private String id;
    @ApiModelProperty(name = "로그인 PW", example = "aaaasdasda")
    private String password;
}
