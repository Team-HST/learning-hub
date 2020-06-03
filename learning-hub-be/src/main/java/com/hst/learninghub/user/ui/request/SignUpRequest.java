package com.hst.learninghub.user.ui.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SignUpRequest {
    @ApiModelProperty(position = 1, example = "ID")
    private String id;
    @ApiModelProperty(position = 2, example = "비밀번호")
    private String password;
    @ApiModelProperty(position = 3, example = "이름")
    private String name;
    @ApiModelProperty(position = 4, example = "생년월일")
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @ApiModelProperty(position = 5, example = "역할")
    private String roleType;

    @Builder(builderClassName = "SignUpBuilder", builderMethodName = "SignUpBuilder")
    public SignUpRequest(String id, String name, String password, LocalDate birthDate, String roleType) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birthDate = birthDate;
        this.roleType = roleType;
    }
}
