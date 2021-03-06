package com.hst.learninghub.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.hst.learninghub.common.exception.SystemException;
import lombok.experimental.UtilityClass;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@UtilityClass
public class JsonUtils {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static String serialize(Object obj) {
		try {
			return OBJECT_MAPPER.writeValueAsString(obj);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	public static <T> T deserialize(String json, Class<T> clazz) {
		try {
			return OBJECT_MAPPER.readValue(json, clazz);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	public static <T> T deserialize(String json, TypeReference<T> typeReference) {
		try {
			return OBJECT_MAPPER.readValue(json, typeReference);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	public static <T> List<T> deserializeArray(String json, Class<T> clazz) {
		try {
			return OBJECT_MAPPER.readValue(json, TypeFactory.defaultInstance().constructCollectionType(List.class, clazz));
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	public static boolean isValidJson(String json) {
		try {
			OBJECT_MAPPER.readTree(json);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}