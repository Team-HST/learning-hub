package com.hst.learninghub.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * @author dlgusrb0808@gmail.com
 */
@UtilityClass
public class FileUtils {

	public static String generateFileName() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String getExtension(String fileName) {
		if (!StringUtils.isEmpty(fileName)) {
			String[] fileTokens = fileName.split("\\.");
			return fileTokens[fileTokens.length - 1];
		}
		return "";
	}

}
