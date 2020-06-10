package com.hst.learninghub.file.type;

import com.hst.learninghub.common.converter.EnumAttributeConverter;
import com.hst.learninghub.common.type.PersistableType;
import com.hst.learninghub.utils.EnumUtils;

import java.util.Map;

/**
 * @author dlgusrb0808@gmail.com
 */
public enum FileType implements PersistableType<String> {
	THUMBNAIL("F001", "컨텐츠 썸네일", "컨텐츠를 대표하는 썸네일"),
	MAIN_MOVIE("F002", "컨텐츠 메인 동영상", "컨텐츠 메인 동영상"),
	ATTACHMENT("F003", "컨텐츠 첨부파일", "썸네일, 동영상을 제외한 나머지 첨부파일")
	;

	private static final Map<String, FileType> FINDER = EnumUtils.asMap(FileType.class);

	private String code;
	private String codeName;
	private String description;

	FileType(String code, String codeName, String description) {
		this.code = code;
		this.codeName = codeName;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getCodeName() {
		return codeName;
	}

	public String getDescription() {
		return description;
	}

	public static class Converter extends EnumAttributeConverter<FileType, String> {
		public Converter() {
			super(FileType.class, false);
		}
	}
}
