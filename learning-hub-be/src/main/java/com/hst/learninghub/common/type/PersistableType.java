package com.hst.learninghub.common.type;

/**
 * @author dlgusrb0808@gmail.com
 */
public interface PersistableType<T> {
	T getCode();
	String getCodeName();
	String getDescription();
}
