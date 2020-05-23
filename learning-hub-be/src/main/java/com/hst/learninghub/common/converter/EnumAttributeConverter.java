package com.hst.learninghub.common.converter;


import com.hst.learninghub.common.exception.ServiceException;
import com.hst.learninghub.common.type.PersistableType;

import java.util.EnumSet;

/**
 * @author dlgusrb0808@gmail.com
 */
public abstract class EnumAttributeConverter<X extends Enum<X> & PersistableType<Y>, Y> extends TypeProvideAttributeConverter<X, Y> {

	public EnumAttributeConverter(Class<X> targetEnumClass, boolean nullable) {
		super(targetEnumClass, nullable);
	}

	@Override
	public Y convertToDatabaseColumn(X attribute) {
		assertArgumentNotNull(attribute);
		return attribute.getCode();
	}

	@Override
	public X convertToEntityAttribute(Y code) {
		assertArgumentNotNull(code);

		return EnumSet.allOf(targetClass).stream()
				.filter(e -> e.getCode().equals(code))
				.findAny()
				.orElseThrow(() -> new ServiceException("변환할 수 없는 타입입니다. %s - %s", targetClass.getSimpleName(), code));
	}

}
