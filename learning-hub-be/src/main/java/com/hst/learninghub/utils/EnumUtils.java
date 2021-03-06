package com.hst.learninghub.utils;

import com.hst.learninghub.common.type.PersistableType;
import lombok.experimental.UtilityClass;

import java.util.EnumSet;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * @author dlgusrb0808@gmail.com
 */
@UtilityClass
public class EnumUtils {

	public static <E extends Enum<E>, K> Map<K, E> asMap(Class<E> enumClass, Function<E, K> keyFunction) {
		return EnumSet.allOf(enumClass).stream()
				.collect(toMap(keyFunction, Function.identity()));
	}

	public static <E extends Enum<E> & PersistableType<K>, K> Map<K, E> asMap(Class<E> enumClass) {
		return EnumSet.allOf(enumClass).stream()
				.collect(toMap(e -> e.getCode(), Function.identity()));
	}
}