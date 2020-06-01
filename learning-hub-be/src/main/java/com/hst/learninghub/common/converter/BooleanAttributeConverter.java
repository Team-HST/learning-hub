package com.hst.learninghub.common.converter;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Converter(autoApply = true)
public class BooleanAttributeConverter implements AttributeConverter<Boolean, String> {

	public static final String YES = "Y";
	public static final String NO = "N";

	@Override
	public String convertToDatabaseColumn(Boolean condition) {
		return condition ? YES : NO;
	}

	@Override
	public Boolean convertToEntityAttribute(String yn) {
		if (StringUtils.equalsAny(yn, YES, NO)) {
			String msg = String.format("Not supported character %s. Only \"Y\" or \"N\"", yn);
			throw new IllegalStateException(msg);
		}

		return YES.equals(yn);
	}
}
