package com.hst.learninghub.user.ui.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class SignUpRequest {
    @ApiModelProperty(position = 1, example = "ID")
    private String id;
    @ApiModelProperty(position = 2, example = "비밀번호")
    private String password;
    @ApiModelProperty(position = 3, example = "이름")
    private String name;
    @ApiModelProperty(position = 4, example = "생년월일")
    private String birthDate;
    @ApiModelProperty(position = 5, example = "역할")
    private String roleType;
    @ApiModelProperty(position = 6, value = "썸네일", hidden = true)
    private MultipartFile profileImage;

    @Builder(builderClassName = "SignUpBuilder", builderMethodName = "SignUpBuilder")
    public SignUpRequest(String id, String name, String password, String birthDate, String roleType) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birthDate = birthDate;
        this.roleType = roleType;
    }
}
