package com.hst.learninghub.authentication;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AuthenticationToken {
    private String token;
    private Long userNo;
}
