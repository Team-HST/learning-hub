package com.hst.learninghub.calculate.type;

import com.hst.learninghub.common.converter.EnumAttributeConverter;
import com.hst.learninghub.common.type.PersistableType;
import com.hst.learninghub.utils.EnumUtils;

import java.util.Map;

public enum CalculateType implements PersistableType<String> {
    PERIODICAL("C001", "주기 정산", "주기적으로 정산"),
    IMMEDIATE("C002", "즉시 정산", "즉시 정산")
    ;

    private String code;
    private String codeName;
    private String description;

    private static final Map<String, CalculateType> FINDER = EnumUtils.asMap(CalculateType.class);

    CalculateType(String code, String codeName, String description) {
        this.code = code;
        this.codeName = codeName;
        this.description = description;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    public static class Converter extends EnumAttributeConverter<CalculateType, String> {
        public Converter() { super(CalculateType.class, false); }
    }
}
