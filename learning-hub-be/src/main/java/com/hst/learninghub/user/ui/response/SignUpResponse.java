package com.hst.learninghub.user.ui.response;

import com.hst.learninghub.user.entity.User;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class SignUpResponse {
    private Long no;
    private String id;
    private String name;
    private LocalDateTime birthDate;
    private String roleType;

    public static SignUpResponse from(User entity){
        SignUpResponse response = new SignUpResponse();
        response.no = entity.getNo();
        response.id = entity.getId();
        response.name = entity.getName();
        response.birthDate = entity.getBirthDate();
        response.roleType = entity.getRoleType().getCode();
        return response;
    }
}