package com.hst.learninghub.user.type;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hst.learninghub.common.type.PersistableType;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LoginStatus implements PersistableType<String> {
    SUCCESS("L001", "로그인 성공", "로그인 성공"),
    INVALID_ID("L101", "유효하지 않은 아이디", "유효하지 않은 ID"),
    INVALID_PASSWORD("L102", "패스워드 인증 실패", "패스워드 인증 실패");

    private String code;
    private String codeName;
    private String description;

    LoginStatus(String code, String codeName, String description) {
        this.code = code;
        this.codeName = codeName;
        this.description = description;
    }
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getCodeName() {
        return codeName;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
