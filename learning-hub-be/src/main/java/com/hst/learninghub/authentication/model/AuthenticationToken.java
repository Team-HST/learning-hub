package com.hst.learninghub.authentication.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AuthenticationToken {
    private String token;
}
