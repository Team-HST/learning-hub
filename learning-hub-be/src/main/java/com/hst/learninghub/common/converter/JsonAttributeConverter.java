package com.hst.learninghub.common.converter;

import com.hst.learninghub.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author dlgusrb0808@gmail.com
 */
public class JsonAttributeConverter<T> extends TypeProvideAttributeConverter<T, String> {

	public JsonAttributeConverter(Class<T> targetClass, boolean nullable) {
		super(targetClass, nullable);
	}

	@Override
	public String convertToDatabaseColumn(T attribute) {
		assertArgumentNotNull(attribute);
		return attribute == null ? null : JsonUtils.serialize(attribute);
	}

	@Override
	public T convertToEntityAttribute(String json) {
		assertArgumentNotNull(json);
		return StringUtils.isEmpty(json) ? null : JsonUtils.deserialize(json, getTargetClass());
	}
}
